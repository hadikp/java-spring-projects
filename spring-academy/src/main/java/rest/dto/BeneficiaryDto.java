package rest.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDto {

    private Long id;

    private String name;

    private BigDecimal allocationPercentage;

    private BigDecimal savings;
}
