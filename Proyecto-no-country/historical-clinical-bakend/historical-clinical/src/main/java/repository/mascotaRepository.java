package repository;

import model.mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mascotaRepository extends JpaRepository<mascota, Integer> {
    List<mascota> findByNombre(String nombre);
    List<mascota> findByTipoMascotaIdTipoMascota(Integer idTipoMascota);
    List<mascota> findByGenero(String genero);
}