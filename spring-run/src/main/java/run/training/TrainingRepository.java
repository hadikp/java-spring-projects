package run.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    //@Query("SELECT y.yearlyKm FROM Training y ORDER BY y.id DESC")
    //BigDecimal findLatestSumYearKm();
    Training findFirstByOrderByIdDesc();
}
