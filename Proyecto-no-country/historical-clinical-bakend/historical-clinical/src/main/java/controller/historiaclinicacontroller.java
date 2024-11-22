package controller;

import model.historiaclinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.historiaclinicaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historias-clinicas")
public class historiaclinicacontroller {

    private final historiaclinicaService historiaclinicaService;

    @Autowired
    public historiaclinicacontroller(historiaclinicaService historiaclinicaService) {
        this.historiaclinicaService = historiaclinicaService;
    }

    @GetMapping
    public ResponseEntity<List<historiaclinica>> getAllHistoriasClinicas() {
        List<historiaclinica> historiasclinicas = historiaclinicaService.getAllHistoriasClinicas();
        return new ResponseEntity<>(historiasclinicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<historiaclinica> getHistoriaClinicaById(@PathVariable Integer id) {
        Optional<historiaclinica> historiaClinica = historiaclinicaService.getHistoriaClinicaById(id);
        return historiaClinica.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<historiaclinica> createHistoriaClinica(@RequestBody historiaclinica historiaClinica) {
        historiaclinica savedHistoriaClinica = historiaclinicaService.saveHistoriaClinica(historiaClinica);
        return new ResponseEntity<>(savedHistoriaClinica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<historiaclinica> updateHistoriaClinica(@PathVariable Integer id, @RequestBody historiaclinica historiaClinicaDetails) {
        historiaclinica updatedHistoriaClinica = historiaclinicaService.updateHistoriaClinica(id, historiaClinicaDetails);
        if (updatedHistoriaClinica != null) {
            return new ResponseEntity<>(updatedHistoriaClinica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoriaClinica(@PathVariable Integer id) {
        historiaclinicaService.deleteHistoriaClinica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/fecha")
    public ResponseEntity<List<historiaclinica>> getHistoriasClinicasByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<historiaclinica> historiasclinicas = historiaclinicaService.getHistoriasClinicasByDateRange(startDate, endDate);
        return new ResponseEntity<>(historiasclinicas, HttpStatus.OK);
    }
}