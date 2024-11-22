package repository;

import model.tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface tipo_personaRepository extends JpaRepository<tipo_persona, Integer> {
    Optional<tipo_persona> findByNombre(String nombre);
}