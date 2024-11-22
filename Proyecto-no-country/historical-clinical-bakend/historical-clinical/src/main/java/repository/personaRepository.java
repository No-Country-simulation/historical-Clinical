package repository;

import model.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personaRepository extends JpaRepository<persona, Integer> {
    List<persona> findByNombres(String nombres);
    List<persona> findByApellidos(String apellidos);
    List<persona> findByEmail(String email);

}
