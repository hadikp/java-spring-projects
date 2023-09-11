package marketplace.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import marketplace.product.Product;
import marketplace.product.ProductNotFoundException;
import marketplace.product.ProductRepository;
import marketplace.wish.Wish;
import marketplace.wish.WishNotFoundException;
import marketplace.wish.WishRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;
    private WishRepository wishRepository;

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<UserProductDto> listAllUser() {
        List<User> users = repository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserProductDto.class)).collect(Collectors.toList());
    }

    public UserProductDto findUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserProductDto.class);
    }

    public UserProductDto createUser(UserCommand command) {
        List<Wish> wishes = command.getWishes();
        User user = new User(command.getName(), command.getCity(), command.getUserName(), command.getEmail(), command.getPassword(),
                command.getRole(), command.getRegistrationDate());
        user.setWishes(wishes);
        repository.save(user);
        return modelMapper.map(user, UserProductDto.class);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public UserProductDto updateUser(Long id, UpdateUser command) {
        User findUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        findUser.setName(command.getName());
        findUser.setCity(command.getCity());
        findUser.setUserName(command.getUserName());
        findUser.setEmail(command.getEmail());
        findUser.setPassword(command.getPassword());
        findUser.setRole(command.getRole());
        findUser.setRegistrationDate(command.getRegistrationDate());
        return modelMapper.map(findUser, UserProductDto.class);
    }


    public UserProductDto userAddWish(Long id, UserAddWishCommand command) {
        List<Wish> wishes = command.getWishes();
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setWishes(wishes);

        //if user exist I need to add wishes to the user, and save the new wishes
        for(int i = 0; i < wishes.size(); i++){
            wishRepository.save(wishes.get(i));
        }
        return modelMapper.map(user, UserProductDto.class);
    }

    public UserProductDto userAddExistingWish(Long userId, Long wishId) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Wish wish = wishRepository.findById(wishId).orElseThrow(() -> new WishNotFoundException(wishId));

        //Is Product included in the user product list?
        Boolean userWishes= repository.findWishThisUser(userId).getWishes().contains(wish);
        if(userWishes){
            System.out.println("This wish is already in user wishes list");
        }else {
            user.addWish(wish);
            repository.save(user);
        }
        return modelMapper.map(user, UserProductDto.class);
    }

    public UserProductDto userAddExistingProduct(Long userId, Long productId) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        //Is Product included in the user product list?
        Boolean userProducts = repository.findProductThisUser(userId).getProducts().contains(product);
        if(userProducts){
            System.out.println("This product is already in user product list");
        }else{
            user.addProduct(product);
            repository.save(user);
        }
        return modelMapper.map(user, UserProductDto.class);
    }
    public FireStoreDto firebaseData(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("cusers").document(documentId);
        ApiFuture<DocumentSnapshot> snapshot = documentReference.get();
        DocumentSnapshot document = snapshot.get();
        System.out.println(document);
        return modelMapper.map(document, FireStoreDto.class);
    }


    public String createFirestore(FireStoreDto fireStoreDto) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String name = fireStoreDto.getName();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("cusers").document("user1").create(fireStoreDto);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
