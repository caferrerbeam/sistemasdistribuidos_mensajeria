package edu.caferrerb.personProducer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.caferrerb.personProducer.model.Person;
import edu.caferrerb.personProducer.services.PersonService;
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
    public ResponseEntity<String> create(@RequestBody  Person person) throws JsonProcessingException {
        personService.create(person);

        return new ResponseEntity("Persona en creacion.", HttpStatus.ACCEPTED);
    }
}
