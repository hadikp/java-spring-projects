package pf.user;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    private static final String COLLECTION_NAME = "users";



    public String createUser(String id, UserCommand command) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id).create(command);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public List<UserDto> getAllUsers() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<UserDto> userList = new ArrayList<>();
        UserDto userDto = null;
        while (iterator.hasNext()){
            DocumentReference documentReferenceIt = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReferenceIt.get();
            DocumentSnapshot document = future.get();
            userDto = document.toObject(UserDto.class);
            userList.add(userDto);
        }
        return userList;
    }

    public String deleteUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();
        return "Succesfully deleted: " + id;
    }

    /*public UserDto updateUser(String id, UserCommand command) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id).create(command);
    }*/
}
