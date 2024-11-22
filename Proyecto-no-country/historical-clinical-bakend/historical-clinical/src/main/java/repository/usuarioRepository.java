package repository;

import model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface usuarioRepository extends JpaRepository<usuario, Integer> {
    Optional<usuario> findByContraseña(String contraseña);
}
