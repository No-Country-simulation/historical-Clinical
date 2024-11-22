package controller;

import model.tipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.tipoUsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-usuario")
public class tipoUsuariocontroller {

    private final tipoUsuarioService tipoUsuarioService;

    @Autowired
    public tipoUsuariocontroller(tipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping
    public ResponseEntity<List<tipoUsuario>> getAllTiposUsuario() {
        List<tipoUsuario> tiposUsuario = tipoUsuarioService.getAllTiposUsuario();
        return new ResponseEntity<>(tiposUsuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tipoUsuario> getTipoUsuarioById(@PathVariable Integer id) {
        Optional<tipoUsuario> tipoUsuario = tipoUsuarioService.getTipoUsuarioById(id);
        return tipoUsuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<tipoUsuario> getTipoUsuarioByNombre(@PathVariable String nombre) {
        Optional<tipoUsuario> tipoUsuario = tipoUsuarioService.getTipoUsuarioByNombre(nombre);
        return tipoUsuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/permiso/{permiso}")
    public ResponseEntity<List<tipoUsuario>> getTiposUsuarioByPermiso(@PathVariable String permiso) {
        List<tipoUsuario> tiposUsuario = tipoUsuarioService.getTiposUsuarioByPermiso(permiso);
        return new ResponseEntity<>(tiposUsuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<tipoUsuario> createTipoUsuario(@RequestBody tipoUsuario tipoUsuario) {
        tipoUsuario savedTipoUsuario = tipoUsuarioService.saveTipoUsuario(tipoUsuario);
        return new ResponseEntity<>(savedTipoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tipoUsuario> updateTipoUsuario(@PathVariable Integer id, @RequestBody tipoUsuario tipoUsuarioDetails) {
        tipoUsuario updatedTipoUsuario = tipoUsuarioService.updateTipoUsuario(id, tipoUsuarioDetails);
        if (updatedTipoUsuario != null) {
            return new ResponseEntity<>(updatedTipoUsuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoUsuario(@PathVariable Integer id) {
        tipoUsuarioService.deleteTipoUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
