package service;

import model.tipo_persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.tipo_personaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class tipo_personaService {

    private final tipo_personaRepository tipo_personaRepository;

    @Autowired
    public tipo_personaService(tipo_personaRepository tipo_personaRepository) {
        this.tipo_personaRepository = tipo_personaRepository;
    }

    public List<tipo_persona> getAllTiposPersona() {
        return tipo_personaRepository.findAll();
    }

    public Optional<tipo_persona> getTipoPersonaById(Integer id) {
        return tipo_personaRepository.findById(id);
    }

    public Optional<tipo_persona> getTipoPersonaByNombre(String nombre) {
        return tipo_personaRepository.findByNombre(nombre);
    }

    public tipo_persona saveTipoPersona(tipo_persona tipoPersona) {
        return tipo_personaRepository.save(tipoPersona);
    }

    public void deleteTipoPersona(Integer id) {
        tipo_personaRepository.deleteById(id);
    }

    public tipo_persona updateTipoPersona(Integer id, tipo_persona tipoPersonaDetails) {
        Optional<tipo_persona> tipoPersona = tipo_personaRepository.findById(id);
        if (tipoPersona.isPresent()) {
            tipo_persona existingTipoPersona = tipoPersona.get();
            existingTipoPersona.setNombre(tipoPersonaDetails.getNombre());
            return tipo_personaRepository.save(existingTipoPersona);
        }
        return null;
    }
}