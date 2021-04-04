package com.caferrer.kafkaconsumer.services;

import com.caferrer.kafkaconsumer.model.entities.Persona;
import com.caferrer.kafkaconsumer.repositories.PersonaRepository;
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
