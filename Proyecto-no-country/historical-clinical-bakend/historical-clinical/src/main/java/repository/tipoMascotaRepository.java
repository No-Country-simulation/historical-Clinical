package repository;

import model.tipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface tipoMascotaRepository extends JpaRepository<tipoMascota, Integer> {
    Optional<tipoMascota> findByNombre(String nombre);
}
