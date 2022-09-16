package una.ac.cr.webservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.webservice.entity.Persona;
import una.ac.cr.webservice.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaRest{
    @Autowired
    private PersonaRepository personaRepository;


    @GetMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<Persona>> findAll() {
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas::add);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if (!persona.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(persona.get());
    }

    @PostMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaRepository.save(persona));
    }

    @PutMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Persona> update(@RequestBody Persona persona){
        if (!personaRepository.findById(persona.getId()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(personaRepository.save(persona));
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity delete(@PathVariable Long id) {
        if (!personaRepository.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        personaRepository.delete(personaRepository.findById(id).get());
        return ResponseEntity.ok().build();
    }

}
