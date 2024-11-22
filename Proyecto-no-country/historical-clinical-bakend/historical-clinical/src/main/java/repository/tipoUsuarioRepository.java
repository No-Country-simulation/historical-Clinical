package repository;

import model.tipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface tipoUsuarioRepository extends JpaRepository<tipoUsuario, Integer> {
    Optional<tipoUsuario> findByNombre(String nombre);
    List<tipoUsuario> findByPermisosContaining(String permiso);
}