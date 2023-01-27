package marketplace.comment;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CommentService {

    private CommentRepository repository;
    private ModelMapper modelMapper;

    public List<CommentDto> listAllComment() {
        List<Comment> comments = repository.findAll();
        return comments.stream().map(c -> modelMapper.map(c, CommentDto.class)).collect(Collectors.toList());
    }

    public CommentDto findCommentById(Long id) {
        Comment comment = repository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
        return modelMapper.map(comment, CommentDto.class);
    }

    public CommentDto createComment(CommentCommand command) {
        Comment comment = new Comment(command.getContent(), command.getCreateDate());
        repository.save(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    public void deleteComment(Long id) {
        repository.deleteById(id);
    }
}
