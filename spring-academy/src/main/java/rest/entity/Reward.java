package rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String confirmationNumber;

    @Column(nullable = false)
    private BigDecimal rewardAmount;

    @Column(nullable = false)
    private LocalDate rewardDate;

    @Column(nullable = false, length = 9)
    private String accountNumber;

    @Column(nullable = false)
    private BigDecimal diningAmount;

    @Column(nullable = false, length = 10)
    private String diningMerchantNumber;

    @Column(nullable = false)
    private LocalDate diningDate;
}
