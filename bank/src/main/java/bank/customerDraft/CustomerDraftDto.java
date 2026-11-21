package bank.customerDraft;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDraftDto {

    private Long id;

    private String taxId;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String phone;

    private String email;

    private BigDecimal monthlyNetIncome;

    private String employerName;

    private LocalDate employmentStartDate;

    private String createdByCode;

    private String createdByName;

    private LocalDateTime createdAt;

}
