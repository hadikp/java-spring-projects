package rest.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rest.dto.AccountDto;
import rest.entity.Account;
import rest.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private AccountRepository repository;
    private ModelMapper modelMapper;

    public AccountService(AccountRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<Account> accounts = repository.findAll();
        return ResponseEntity.ok(accounts.stream().map(a -> modelMapper.map(a, AccountDto.class)).collect(Collectors.toList()));
    }
}
