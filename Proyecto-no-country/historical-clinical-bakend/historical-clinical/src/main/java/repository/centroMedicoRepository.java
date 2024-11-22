package repository;

import model.centroMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface centroMedicoRepository extends JpaRepository<centroMedico, Integer> {

}
