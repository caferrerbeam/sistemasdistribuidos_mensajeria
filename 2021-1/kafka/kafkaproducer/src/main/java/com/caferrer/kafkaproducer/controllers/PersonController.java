package com.caferrer.kafkaproducer.controllers;

import com.caferrer.kafkaproducer.model.Person;
import com.caferrer.kafkaproducer.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Person person) throws JsonProcessingException {
        personService.create(person);

        return new ResponseEntity("Persona en creacion.", HttpStatus.ACCEPTED);
    }
}
