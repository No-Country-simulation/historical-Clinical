package service;

import model.persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.personaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class personaService {

    private final personaRepository personaRepository;

    @Autowired
    public personaService(personaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<persona> getPersonaById(Integer id) {
        return personaRepository.findById(id);
    }

    public persona savePersona(persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    public persona updatePersona(Integer id, persona personaDetails) {
        Optional<persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            persona existingPersona = persona.get();
            existingPersona.setNombres(personaDetails.getNombres());
            existingPersona.setApellidos(personaDetails.getApellidos());
            existingPersona.setTelefono(personaDetails.getTelefono());
            existingPersona.setEmail(personaDetails.getEmail());
            existingPersona.setDireccion(personaDetails.getDireccion());

            return personaRepository.save(existingPersona);
        }
        return null;
    }

    public List<persona> getPersonasByNombres(String nombres) {
        return personaRepository.findByNombres(nombres);
    }

    public List<persona> getPersonasByApellidos(String apellidos) {
        return personaRepository.findByApellidos(apellidos);
    }

    public List<persona> getPersonasByEmail(String email) {
        return personaRepository.findByEmail(email);
    }


}
