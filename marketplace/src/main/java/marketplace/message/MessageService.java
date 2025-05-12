package marketplace.message;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository repository;
    private ModelMapper modelMapper;

    public List<MessageDto> listAllMessage() {
        List<Message> messages = repository.findAll();
        return messages.stream().map(m -> modelMapper.map(m, MessageDto.class)).collect(Collectors.toList());
    }

    public MessageDto findMessageById(Long id) {
        Message message = repository.findById(id).orElseThrow(() -> new MessageNotFound(id));
        return modelMapper.map(message, MessageDto.class);
    }

    /*public MessageDto createMessage(MessageCommand command) {
        Message message = new Message(command.getSubject(), command.getContent(), command.getCreateDate());
        repository.save(message);
        return modelMapper.map(message, MessageDto.class);
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public MessageDto updateMessage(Long id, UpdateMessage command) {
        Message findMessage = repository.findById(id).orElseThrow(() -> new MessageNotFound(id));
        findMessage.setSubject(command.getSubject());
        findMessage.setContent(command.getContent());
        findMessage.setCreateDate(command.getCreateDate());
        return modelMapper.map(findMessage, MessageDto.class);
    }*/
}
