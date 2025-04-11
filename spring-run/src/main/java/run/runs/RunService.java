package run.runs;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RunService {

    private RunRepository runRepository;
    private ModelMapper modelMapper;

    public List<RunDto> listAllRaces() {
        List<Run> runs = runRepository.findAll();
        return runs.stream().map(r -> modelMapper.map(r, RunDto.class)).collect(Collectors.toList());
    }

    public void deleteRun(Long id) {
        runRepository.deleteById(id);
    }

    public RunDto createRun(RunCommand command) {
        Run run = new Run(command.getType(), command.getDescription(), command.getKm(), command.getDate());
        runRepository.save(run);
        return modelMapper.map(run, RunDto.class);
    }
}
