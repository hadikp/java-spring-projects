package bank.customerDraft;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_draft", schema = "businnesdata")
public class CustomerDraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tax_id", nullable = false, unique = true)
    private String taxId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String phone;

    private String email;

    @Column(name = "monthly_net_income")
    private BigDecimal monthlyNetIncome;

    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "employment_start_date")
    private LocalDate employmentStartDate;

    @Column(name = "created_by_code")
    private String createdByCode;

    @Column(name = "created_by_name")
    private String createdByName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public CustomerDraft(String taxId, String firstName, String lastName, LocalDate birthDate, String phone, String email, BigDecimal monthlyNetIncome, String employerName, LocalDate employmentStartDate, String createdByCode, String createdByName, LocalDateTime createdAt) {
        this.taxId = taxId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.monthlyNetIncome = monthlyNetIncome;
        this.employerName = employerName;
        this.employmentStartDate = employmentStartDate;
        this.createdByCode = createdByCode;
        this.createdByName = createdByName;
        this.createdAt = createdAt;
    }
}
