package una.ac.cr.webservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.webservice.entity.Log;
import una.ac.cr.webservice.repository.LogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogRest {
    @Autowired
    private LogRepository logRepository;

    @GetMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<Log>> findAll() {
        List<Log> logs = new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return ResponseEntity.ok(logs);
    }


}
