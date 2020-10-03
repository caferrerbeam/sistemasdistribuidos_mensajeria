package co.edu.eam.sistemasdistribuidos.queueproducer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Value("${messaging.queues.process.name}")
  private String processQueueName;

  @Value("${messaging.queues.process.key}")
  private String processQueueKey ;

  @Value("${messaging.routing.direct}")
  private String directExchangeName ;

  @Bean
  Queue processQueue() {
    return new Queue(processQueueName, false);
  }

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange(directExchangeName);
  }

  @Bean
  Binding bindingProcessExchangeToProcessQueue(Queue processQueue, DirectExchange processExchange) {
    return BindingBuilder.bind(processQueue).to(processExchange).with(processQueueKey);
  }

}
