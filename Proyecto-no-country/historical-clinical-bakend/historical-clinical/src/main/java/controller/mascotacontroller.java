package controller;

import model.mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.mascotaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class mascotacontroller {

    private final mascotaService mascotaService;

    @Autowired
    public mascotacontroller(mascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<mascota>> getAllMascotas() {
        List<mascota> mascotas = mascotaService.getAllMascotas();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<mascota> getMascotaById(@PathVariable Integer id) {
        Optional<mascota> mascota = mascotaService.getMascotaById(id);
        return mascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<mascota> createMascota(@RequestBody mascota mascota) {
        mascota savedMascota = mascotaService.saveMascota(mascota);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<mascota> updateMascota(@PathVariable Integer id, @RequestBody mascota mascotaDetails) {
        mascota updatedMascota = mascotaService.updateMascota(id, mascotaDetails);
        if (updatedMascota != null) {
            return new ResponseEntity<>(updatedMascota, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Integer id) {
        mascotaService.deleteMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<mascota>> getMascotasByNombre(@PathVariable String nombre) {
        List<mascota> mascotas = mascotaService.getMascotasByNombre(nombre);
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/tipo-mascota/{idTipoMascota}")
    public ResponseEntity<List<mascota>> getMascotasByTipoMascota(@PathVariable Integer idTipoMascota) {
        List<mascota> mascotas = mascotaService.getMascotasByTipoMascota(idTipoMascota);
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<mascota>> getMascotasByGenero(@PathVariable String genero) {
        List<mascota> mascotas = mascotaService.getMascotasByGenero(genero);
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }
}