package run.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private TrainingService service;

    public TrainingController(TrainingService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrainingDto> listAllTraining(){
        return service.listAllTraining();
    }

    @GetMapping("/latestYearKm")
    public BigDecimal latestSumYearKm(){
        return service.getLatestKm();
    }
}
