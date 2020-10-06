package com.example.demo.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonsErrorProducer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;

  public void produceErrorPerson(String message) {
    rabbitTemplate.convertAndSend(directExchange.getName(), "person_error", message);
  }

}
