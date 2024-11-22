package controller;

import model.centroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.centroMedicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/centros-medicos")
public class centroMedicocontroller {

    private final centroMedicoService centroMedicoService;

    @Autowired
    public centroMedicocontroller(centroMedicoService centroMedicoService) {
        this.centroMedicoService = centroMedicoService;
    }

    @GetMapping
    public ResponseEntity<List<centroMedico>> getAllCentrosMedicos() {
        List<centroMedico> centrosMedicos = centroMedicoService.getAllCentrosMedicos();
        return new ResponseEntity<>(centrosMedicos, HttpStatus.OK);
    }

    @GetMapping("/{nitCentroMedico}")
    public ResponseEntity<centroMedico> getCentroMedicoById(@PathVariable Integer nitCentroMedico) {
        Optional<centroMedico> centroMedico = centroMedicoService.getCentroMedicoById(nitCentroMedico);
        return centroMedico.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<centroMedico> createCentroMedico(@RequestBody centroMedico centroMedico) {
        centroMedico savedCentroMedico = centroMedicoService.saveCentroMedico(centroMedico);
        return new ResponseEntity<>(savedCentroMedico, HttpStatus.CREATED);
    }

    @PutMapping("/{nitCentroMedico}")
    public ResponseEntity<centroMedico> updateCentroMedico(@PathVariable Integer nitCentroMedico, @RequestBody centroMedico centroMedicoDetails) {
        centroMedico updatedCentroMedico = centroMedicoService.updateCentroMedico(nitCentroMedico, centroMedicoDetails);
        if (updatedCentroMedico != null) {
            return new ResponseEntity<>(updatedCentroMedico, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{nitCentroMedico}")
    public ResponseEntity<Void> deleteCentroMedico(@PathVariable Integer nitCentroMedico) {
        centroMedicoService.deleteCentroMedico(nitCentroMedico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}