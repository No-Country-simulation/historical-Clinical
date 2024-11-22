package service;

import model.historiaclinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.historiaclinicaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class historiaclinicaService {

    private final historiaclinicaRepository historiaclinicaRepository;

    @Autowired
    public historiaclinicaService(historiaclinicaRepository historiaClinicaRepository) {
        this.historiaclinicaRepository = historiaClinicaRepository;
    }

    public List<historiaclinica> getAllHistoriasClinicas() {
        return historiaclinicaRepository.findAll();
    }

    public Optional<historiaclinica> getHistoriaClinicaById(Integer id) {
        return historiaclinicaRepository.findById(id);
    }

    public historiaclinica saveHistoriaClinica(historiaclinica historiaClinica) {
        return historiaclinicaRepository.save(historiaClinica);
    }

    public void deleteHistoriaClinica(Integer id) {
        historiaclinicaRepository.deleteById(id);
    }

    public historiaclinica updateHistoriaClinica(Integer id, historiaclinica historiaClinicaDetails) {
        Optional<historiaclinica> historiaClinica = historiaclinicaRepository.findById(id);
        if (historiaClinica.isPresent()) {
            historiaclinica existingHistoriaClinica = historiaClinica.get();
            existingHistoriaClinica.setFecha(historiaClinicaDetails.getFecha());
            existingHistoriaClinica.setDescripcion(historiaClinicaDetails.getDescripcion());

            return historiaclinicaRepository.save(existingHistoriaClinica);
        }
        return null;
    }



    public List<historiaclinica> getHistoriasClinicasByDateRange(LocalDate startDate, LocalDate endDate) {
        return historiaclinicaRepository.findByFechaBetween(startDate, endDate);
    }
}
