package bank.customerDraft;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/draft")
public class CustomerDraftController {

    public CustomerDraftService service;

    public CustomerDraftController(CustomerDraftService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDraftDto>> getallDraft(){
        List<CustomerDraftDto> drafts = service.getAllCustomerDraft();
        return ResponseEntity.ok(drafts);
    }
}
