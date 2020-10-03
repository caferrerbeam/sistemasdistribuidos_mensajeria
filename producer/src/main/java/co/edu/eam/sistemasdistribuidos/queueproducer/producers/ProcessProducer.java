package co.edu.eam.sistemasdistribuidos.queueproducer.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProcessProducer {

  @Value("${messaging.queues.process.key}")
  private String processKey;

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private DirectExchange direct;

  public void produce(String message) {
    template.convertAndSend(direct.getName(), processKey, message);
  }
}
