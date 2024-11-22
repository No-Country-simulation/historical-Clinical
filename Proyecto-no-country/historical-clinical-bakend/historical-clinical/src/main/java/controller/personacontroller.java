package controller;

import model.persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.personaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class personacontroller {

    private final personaService personaService;

    @Autowired
    public personacontroller(personaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<persona>> getAllPersonas() {
        List<persona> personas = personaService.getAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<persona> getPersonaById(@PathVariable Integer id) {
        Optional<persona> persona = personaService.getPersonaById(id);
        return persona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<persona> createPersona(@RequestBody persona persona) {
        persona savedPersona = personaService.savePersona(persona);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<persona> updatePersona(@PathVariable Integer id, @RequestBody persona personaDetails) {
        persona updatedPersona = personaService.updatePersona(id, personaDetails);
        if (updatedPersona != null) {
            return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombres/{nombres}")
    public ResponseEntity<List<persona>> getPersonasByNombres(@PathVariable String nombres) {
        List<persona> personas = personaService.getPersonasByNombres(nombres);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/apellidos/{apellidos}")
    public ResponseEntity<List<persona>> getPersonasByApellidos(@PathVariable String apellidos) {
        List<persona> personas = personaService.getPersonasByApellidos(apellidos);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<persona>> getPersonasByEmail(@PathVariable String email) {
        List<persona> personas = personaService.getPersonasByEmail(email);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }


}
