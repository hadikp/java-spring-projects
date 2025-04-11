package run.runs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/run")
public class RunController {

    private RunService service;

    public RunController(RunService service) {
        this.service = service;
    }

    @GetMapping
    public List<RunDto> éistAllRaces(){
        return service.listAllRaces();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RunDto createRun(@RequestBody RunCommand command){
        return service.createRun(command);
    }
}
