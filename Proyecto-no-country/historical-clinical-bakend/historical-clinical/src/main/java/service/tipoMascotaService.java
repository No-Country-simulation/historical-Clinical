package service;

import model.tipoMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.tipoMascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class tipoMascotaService {

    private final tipoMascotaRepository tipoMascotaRepository;

    @Autowired
    public tipoMascotaService(tipoMascotaRepository tipoMascotaRepository) {
        this.tipoMascotaRepository = tipoMascotaRepository;
    }

    public List<tipoMascota> getAllTiposMascota() {
        return tipoMascotaRepository.findAll();
    }

    public Optional<tipoMascota> getTipoMascotaById(Integer id) {
        return tipoMascotaRepository.findById(id);
    }

    public Optional<tipoMascota> getTipoMascotaByNombre(String nombre) {
        return tipoMascotaRepository.findByNombre(nombre);
    }

    public tipoMascota saveTipoMascota(tipoMascota tipoMascota) {
        return tipoMascotaRepository.save(tipoMascota);
    }

    public void deleteTipoMascota(Integer id) {
        tipoMascotaRepository.deleteById(id);
    }

    public tipoMascota updateTipoMascota(Integer id, tipoMascota tipoMascotaDetails) {
        Optional<tipoMascota> tipoMascota = tipoMascotaRepository.findById(id);
        if (tipoMascota.isPresent()) {
            tipoMascota existingTipoMascota = tipoMascota.get();
            existingTipoMascota.setNombre(tipoMascotaDetails.getNombre());
            return tipoMascotaRepository.save(existingTipoMascota);
        }
        return null;
    }
}