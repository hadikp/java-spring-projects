package bank.customerDraft;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerDraftService {

    public ModelMapper modelMapper;
    public CustomerDraftRepository repository;

    public List<CustomerDraftDto> getAllCustomerDraft() {
        List<CustomerDraft> drafts = repository.findAll();
        return drafts.stream().map(d -> modelMapper.map(d, CustomerDraftDto.class)).collect(Collectors.toList());
    }
}
