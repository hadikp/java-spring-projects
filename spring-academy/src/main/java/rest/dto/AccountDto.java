package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {

    private Long id;
    private String number;

    private String name;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    private List<CreditCardDto> creditCards;

    private List<BeneficiaryDto> beneficiaries;

}
