package repository;

import model.historiaclinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface historiaclinicaRepository extends JpaRepository<historiaclinica, Integer> {
    List<historiaclinica> findByFechaBetween(LocalDate startDate, LocalDate endDate);

}
