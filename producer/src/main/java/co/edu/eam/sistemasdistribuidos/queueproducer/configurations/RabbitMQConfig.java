package co.edu.eam.sistemasdistribuidos.queueproducer.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Bean
  public Queue personQueue(){
    return new Queue("persons_queue", true);
  }

  @Bean
  public Queue storesQueue(){
    return new Queue("stores_queue", false);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange("direct_exchange");
  }

  @Bean
  public Binding bindDirectExchangePersonQueue(Queue personQueue, DirectExchange directExchange){
    return BindingBuilder.bind(personQueue).to(directExchange).with("person");
  }

  //@Bean
  public Binding bindDirectExchangeStoresQueue(Queue storesQueue, DirectExchange directExchange){
    return BindingBuilder.bind(storesQueue).to(directExchange).with("stores");
  }
}
