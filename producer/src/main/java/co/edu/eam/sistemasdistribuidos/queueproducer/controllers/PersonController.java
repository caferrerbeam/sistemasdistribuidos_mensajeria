package co.edu.eam.sistemasdistribuidos.queueproducer.controllers;

import co.edu.eam.sistemasdistribuidos.queueproducer.model.requests.Person;
import co.edu.eam.sistemasdistribuidos.queueproducer.producers.ProcessProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
  private ProcessProducer processProducer;

  @PostMapping
  public void create(@RequestBody @Valid Person person){
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String json = objectMapper.writeValueAsString(person);
      processProducer.produce(json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

  }

}
