package edu.caferrerb.personConsumer.services;

import edu.caferrerb.personConsumer.model.entities.Persona;
import edu.caferrerb.personConsumer.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public void create(Persona persona) {
        personaRepository.save(persona);
    }
}
