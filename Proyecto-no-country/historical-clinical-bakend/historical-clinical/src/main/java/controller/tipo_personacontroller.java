package controller;

import model.tipo_persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.tipo_personaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-persona")
public class tipo_personacontroller {

    private final tipo_personaService tipo_personaService;

    @Autowired
    public tipo_personacontroller(tipo_personaService tipo_personaService) {
        this.tipo_personaService = tipo_personaService;
    }

    @GetMapping
    public ResponseEntity<List<tipo_persona>> getAllTiposPersona() {
        List<tipo_persona> tiposPersona = tipo_personaService.getAllTiposPersona();
        return new ResponseEntity<>(tiposPersona, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tipo_persona> getTipoPersonaById(@PathVariable Integer id) {
        Optional<tipo_persona> tipoPersona = tipo_personaService.getTipoPersonaById(id);
        return tipoPersona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<tipo_persona> getTipoPersonaByNombre(@PathVariable String nombre) {
        Optional<tipo_persona> tipoPersona = tipo_personaService.getTipoPersonaByNombre(nombre);
        return tipoPersona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<tipo_persona> createTipoPersona(@RequestBody tipo_persona tipoPersona) {
        tipo_persona savedTipoPersona = tipo_personaService.saveTipoPersona(tipoPersona);
        return new ResponseEntity<>(savedTipoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tipo_persona> updateTipoPersona(@PathVariable Integer id, @RequestBody tipo_persona tipoPersonaDetails) {
        tipo_persona updatedTipoPersona = tipo_personaService.updateTipoPersona(id, tipoPersonaDetails);
        if (updatedTipoPersona != null) {
            return new ResponseEntity<>(updatedTipoPersona, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPersona(@PathVariable Integer id) {
        tipo_personaService.deleteTipoPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}