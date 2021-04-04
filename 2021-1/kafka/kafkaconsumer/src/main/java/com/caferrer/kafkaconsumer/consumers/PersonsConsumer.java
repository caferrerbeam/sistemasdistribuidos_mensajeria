package com.caferrer.kafkaconsumer.consumers;

import com.caferrer.kafkaconsumer.model.entities.Persona;
import com.caferrer.kafkaconsumer.services.PersonaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PersonsConsumer {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "4pduc1fi-persons")
    public void receive(String message) throws JsonProcessingException {
        System.out.println(message);
        Persona persona = objectMapper.readValue(message, Persona.class);

        personaService.create(persona);
    }
}
