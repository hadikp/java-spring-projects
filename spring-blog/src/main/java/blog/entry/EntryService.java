package blog.entry;

import blog.user.User;
import blog.user.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntryService {

    private UserRepository userRepository;
    private EntryRepository repository;
    private ModelMapper modelMapper;

    public List<EntryDto> listAllPost() {
        List<Entry> entries = repository.findAll();
        return entries.stream().map(e -> modelMapper.map(e, EntryDto.class)).collect(Collectors.toList());
    }

    public EntryDto createPost(EntryCommand command) {
        Long id = command.getUserId();
        User user = userRepository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
        Entry post = new Entry(command.getTitle(), command.getDescription(), command.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);
        repository.save(post);
        return modelMapper.map(post, EntryDto.class);
    }

    @Transactional
    public EntryDto updateEntry(Long id, EntryCommand command) {
        Entry findEntry = repository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
        findEntry.setTitle(command.getTitle());
        findEntry.setDescription(command.getDescription());
        //findEntry.setContent(command.getContent());
        return modelMapper.map(findEntry, EntryDto.class);
    }
}
