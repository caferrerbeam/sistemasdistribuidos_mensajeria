package co.edu.eam.sistemasdistribuidos.queueproducer.producers;

import co.edu.eam.sistemasdistribuidos.queueproducer.model.requests.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonsProducer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;

  public void producePerson(Person person) throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    String personJson = objectMapper.writeValueAsString(person);

    rabbitTemplate.convertAndSend(directExchange.getName(), "person",personJson);
  }

}
