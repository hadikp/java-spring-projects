package run.training;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrainingService {
    
    private TrainingRepository repository;
    
    private ModelMapper modelMapper;

    public List<TrainingDto> listAllTraining() {
        List<Training> trainings = repository.findAll();
        return trainings.stream().map(t -> modelMapper.map(t, TrainingDto.class)).collect(Collectors.toList());
    }

    public BigDecimal getLatestKm() {
        Training latestKm = repository.findFirstByOrderByIdDesc();
        return  latestKm.getYearlyKm();
    }
}
