package com.example.demo.consumers;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.model.entities.Person;
import com.example.demo.producers.PersonsErrorProducer;
import com.example.demo.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonsConsumer {

  @Autowired
  private PersonService personService;


  @Autowired
  private PersonsErrorProducer personsErrorProducer;

  @RabbitListener(queues = "#{personQueue.name}")
  public void listenPersonQueue(String message){

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Person person = objectMapper.readValue(message, Person.class);

      if (person.getId() == null || person.getName() == null) {
        return;
      }

      personService.create(person);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }catch (BusinessException exc) {
      exc.printStackTrace();
      personsErrorProducer.produceErrorPerson(message);
    }
  }

}
