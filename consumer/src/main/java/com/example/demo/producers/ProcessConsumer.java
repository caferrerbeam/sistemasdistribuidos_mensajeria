package com.example.demo.producers;

import com.example.demo.model.entities.Person;
import com.example.demo.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessConsumer {

  @Autowired
  private PersonService personService;

  @RabbitListener(queues = "#{processQueue.name}" )
  public void listen(String message) {

    ObjectMapper jsonMapper = new ObjectMapper();
    try {
      Person person = jsonMapper.readValue(message, Person.class);
      personService.create(person);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
