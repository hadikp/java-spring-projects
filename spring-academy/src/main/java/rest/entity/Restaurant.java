package rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String merchantNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal benefitPercentage;

    @Column(nullable = false, length = 1)
    private String benefitAvailabilityPolicy;
}
