package service;

import model.tipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.tipoUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class tipoUsuarioService {

    private final tipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public tipoUsuarioService(tipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<tipoUsuario> getAllTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public Optional<tipoUsuario> getTipoUsuarioById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public Optional<tipoUsuario> getTipoUsuarioByNombre(String nombre) {
        return tipoUsuarioRepository.findByNombre(nombre);
    }

    public List<tipoUsuario> getTiposUsuarioByPermiso(String permiso) {
        return tipoUsuarioRepository.findByPermisosContaining(permiso);
    }

    public tipoUsuario saveTipoUsuario(tipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void deleteTipoUsuario(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }

    public tipoUsuario updateTipoUsuario(Integer id, tipoUsuario tipoUsuarioDetails) {
        Optional<tipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(id);
        if (tipoUsuario.isPresent()) {
            tipoUsuario existingTipoUsuario = tipoUsuario.get();
            existingTipoUsuario.setNombre(tipoUsuarioDetails.getNombre());
            existingTipoUsuario.setDescripcion(tipoUsuarioDetails.getDescripcion());
            existingTipoUsuario.setPermisos(tipoUsuarioDetails.getPermisos());
            return tipoUsuarioRepository.save(existingTipoUsuario);
        }
        return null;
    }
}
