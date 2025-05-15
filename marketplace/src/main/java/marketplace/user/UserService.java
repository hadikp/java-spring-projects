package marketplace.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import marketplace.book.Book;
import marketplace.book.BookNotFoundException;
import marketplace.book.BookRepository;
import marketplace.userbook.UserBookRelationType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;
        private BookRepository bookRepository;
    private ModelMapper modelMapper;

    public List<UserDto> listAllUser() {
        List<User> users = repository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto createUser(UserCommand command) {
        User user = new User(command.getName(), command.getUserName(), command.getEmail(), command.getPassword(),
        command.getRole(), command.getRegistrationDate());
        repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public UserDto updateUser(Long id, UpdateUser command) {
        User findUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        findUser.setName(command.getName());
        findUser.setUserName(command.getUserName());
        findUser.setEmail(command.getEmail());
        findUser.setPassword(command.getPassword());
        findUser.setRole(command.getRole());
        findUser.setRegistrationDate(command.getRegistrationDate());
        return modelMapper.map(findUser, UserDto.class);
    }

    /*public UserProductDto userAddExistingWish(Long userId, Long wishId) {
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
    }*/

    public UserBookDto addExistingBookToUser(Long userId, Long productId, UserBookRelationType relationType) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Book book = bookRepository.findById(productId).orElseThrow(() -> new BookNotFoundException(productId));

        boolean alreadyExists = user.getBookRelations().stream()
                .anyMatch(ub -> ub.getBook().equals(book) && ub.getRelationType() == relationType);

        if (!alreadyExists) {
            user.addBook(book, relationType);
            repository.save(user);
        }
        return modelMapper.map(user, UserBookDto.class);
    }
    public List<FireStoreDto> firebaseDatas() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection("cusers").listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<FireStoreDto> dataList = new ArrayList<>();
        FireStoreDto fireStoreDto = null;
        while (iterator.hasNext()){
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot document = future.get();
            fireStoreDto = document.toObject(FireStoreDto.class);
            dataList.add(fireStoreDto);
        }
        return dataList;
    }


    public String createFirestore(FireStoreDto fireStoreDto) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String name = fireStoreDto.getName();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("cusers").document("user2").create(fireStoreDto);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteFirestore(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("cusers").document(documentId).delete();
        return "Succesfully deleted " + documentId;
    }
}
