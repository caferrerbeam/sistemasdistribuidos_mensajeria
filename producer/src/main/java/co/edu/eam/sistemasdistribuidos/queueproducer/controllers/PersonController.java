package co.edu.eam.sistemasdistribuidos.queueproducer.controllers;

import co.edu.eam.sistemasdistribuidos.queueproducer.model.requests.Person;
import co.edu.eam.sistemasdistribuidos.queueproducer.producers.PersonsProducer;
import co.edu.eam.sistemasdistribuidos.queueproducer.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping
  public void create(@RequestBody @Valid Person person) {
      personService.createPerson(person);
  }

}
