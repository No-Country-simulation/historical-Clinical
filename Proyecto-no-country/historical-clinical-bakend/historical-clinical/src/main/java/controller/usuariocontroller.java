package controller;

import model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.usuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class usuariocontroller {

    private final usuarioService usuarioService;

    @Autowired
    public usuariocontroller(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<usuario>> getAllUsuarios() {
        List<usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<usuario> getUsuarioByCedula(@PathVariable Integer cedula) {
        Optional<usuario> usuario = usuarioService.getUsuarioByCedula(cedula);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/contraseña/{contraseña}")
    public ResponseEntity<usuario> getUsuarioByContraseña(@PathVariable String contraseña) {
        Optional<usuario> usuario = usuarioService.getUsuarioByContraseña(contraseña);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<usuario> createUsuario(@RequestBody usuario usuario) {
        usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<usuario> updateUsuario(@PathVariable Integer cedula, @RequestBody usuario usuarioDetails) {
        usuario updatedUsuario = usuarioService.updateUsuario(cedula, usuarioDetails);
        if (updatedUsuario != null) {
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer cedula) {
        usuarioService.deleteUsuario(cedula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
