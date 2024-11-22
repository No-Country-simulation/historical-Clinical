package service;

import model.centroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.centroMedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class centroMedicoService {

    private final centroMedicoRepository centroMedicoRepository;

    @Autowired
    public centroMedicoService(centroMedicoRepository centroMedicoRepository) {
        this.centroMedicoRepository = centroMedicoRepository;
    }

    public List<centroMedico> getAllCentrosMedicos() {
        return centroMedicoRepository.findAll();
    }

    public Optional<centroMedico> getCentroMedicoById(Integer nitCentroMedico) {
        return centroMedicoRepository.findById(nitCentroMedico);
    }

    public centroMedico saveCentroMedico(centroMedico centroMedico) {
        return centroMedicoRepository.save(centroMedico);
    }

    public void deleteCentroMedico(Integer nitCentroMedico) {
        centroMedicoRepository.deleteById(nitCentroMedico);
    }

    public centroMedico updateCentroMedico(Integer nitCentroMedico, centroMedico centroMedicoDetails) {
        Optional<centroMedico> centroMedico = centroMedicoRepository.findById(nitCentroMedico);
        if (centroMedico.isPresent()) {
            centroMedico existingCentroMedico = centroMedico.get();
            existingCentroMedico.setNombre(centroMedicoDetails.getNombre());
            existingCentroMedico.setDireccion(centroMedicoDetails.getDireccion());
            existingCentroMedico.setTelefono(centroMedicoDetails.getTelefono());
            existingCentroMedico.setEmail(centroMedicoDetails.getEmail());
            return centroMedicoRepository.save(existingCentroMedico);
        }
        return null;
    }
}
