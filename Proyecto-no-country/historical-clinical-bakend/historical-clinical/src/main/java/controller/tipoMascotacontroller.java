package controller;

import model.tipoMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.tipoMascotaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-mascota")
public class tipoMascotacontroller {

    private final tipoMascotaService tipoMascotaService;

    @Autowired
    public tipoMascotacontroller(tipoMascotaService tipoMascotaService) {
        this.tipoMascotaService = tipoMascotaService;
    }

    @GetMapping
    public ResponseEntity<List<tipoMascota>> getAllTiposMascota() {
        List<tipoMascota> tiposMascota = tipoMascotaService.getAllTiposMascota();
        return new ResponseEntity<>(tiposMascota, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tipoMascota> getTipoMascotaById(@PathVariable Integer id) {
        Optional<tipoMascota> tipoMascota = tipoMascotaService.getTipoMascotaById(id);
        return tipoMascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<tipoMascota> getTipoMascotaByNombre(@PathVariable String nombre) {
        Optional<tipoMascota> tipoMascota = tipoMascotaService.getTipoMascotaByNombre(nombre);
        return tipoMascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<tipoMascota> createTipoMascota(@RequestBody tipoMascota tipoMascota) {
        tipoMascota savedTipoMascota = tipoMascotaService.saveTipoMascota(tipoMascota);
        return new ResponseEntity<>(savedTipoMascota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tipoMascota> updateTipoMascota(@PathVariable Integer id, @RequestBody tipoMascota tipoMascotaDetails) {
        tipoMascota updatedTipoMascota = tipoMascotaService.updateTipoMascota(id, tipoMascotaDetails);
        if (updatedTipoMascota != null) {
            return new ResponseEntity<>(updatedTipoMascota, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMascota(@PathVariable Integer id) {
        tipoMascotaService.deleteTipoMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}