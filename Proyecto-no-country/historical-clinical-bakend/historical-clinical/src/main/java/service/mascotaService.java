package service;

import model.mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.mascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class mascotaService {

    private final mascotaRepository mascotaRepository;

    @Autowired
    public mascotaService(mascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<mascota> getMascotaById(Integer id) {
        return mascotaRepository.findById(id);
    }

    public mascota saveMascota(mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(Integer id) {
        mascotaRepository.deleteById(id);
    }

    public mascota updateMascota(Integer id, mascota mascotaDetails) {
        Optional<mascota> mascota = mascotaRepository.findById(id);
        if (mascota.isPresent()) {
            mascota existingmascota = mascota.get();
            existingmascota.setNombre(mascotaDetails.getNombre());
            existingmascota.setApellidos(mascotaDetails.getApellidos());
            existingmascota.setEdad(mascotaDetails.getEdad());
            existingmascota.setGenero(mascotaDetails.getGenero());
            existingmascota.setDescripcion(mascotaDetails.getDescripcion());
            existingmascota.setTipoMascota(mascotaDetails.getTipoMascota());
            return mascotaRepository.save(existingmascota);
        }
        return null;
    }

    public List<mascota> getMascotasByNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    public List<mascota> getMascotasByTipoMascota(Integer idTipoMascota) {
        return mascotaRepository.findByTipoMascotaIdTipoMascota(idTipoMascota);
    }

    public List<mascota> getMascotasByGenero(String genero) {
        return mascotaRepository.findByGenero(genero);
    }
}
