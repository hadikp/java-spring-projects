package blog.entry;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntryService {

    private EntryRepository repository;
    private ModelMapper modelMapper;

    public List<EntryDto> listAllPost() {
        List<Entry> entries = repository.findAll();
        return entries.stream().map(e -> modelMapper.map(e, EntryDto.class)).collect(Collectors.toList());
    }

    public EntryDto createPost(EntryCommand command) {
        Entry post = new Entry(command.getTitle(),  command.getDescription(), command.getContent());
        post.setCreatedAt(LocalDateTime.now());
        repository.save(post);
        return modelMapper.map(post, EntryDto.class);
    }
}
