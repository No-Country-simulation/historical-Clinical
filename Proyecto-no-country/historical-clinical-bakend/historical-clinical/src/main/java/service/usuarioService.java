package service;

import model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.usuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    private final usuarioRepository usuarioRepository;

    @Autowired
    public usuarioService(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<usuario> getUsuarioByCedula(Integer cedula) {
        return usuarioRepository.findById(cedula);
    }

    public Optional<usuario> getUsuarioByContraseña(String contraseña) {
        return usuarioRepository.findByContraseña(contraseña);
    }

    public usuario saveUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer cedula) {
        usuarioRepository.deleteById(cedula);
    }

    public usuario updateUsuario(Integer cedula, usuario usuarioDetails) {
        Optional<usuario> usuario = usuarioRepository.findById(cedula);
        if (usuario.isPresent()) {
            usuario existingUsuario = usuario.get();
            existingUsuario.setContraseña(usuarioDetails.getContraseña());
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }
}
