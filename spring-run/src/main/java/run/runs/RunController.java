package run.runs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
