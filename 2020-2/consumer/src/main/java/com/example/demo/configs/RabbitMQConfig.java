package com.example.demo.configs;

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
  public Queue errorPersonsQueue(){
    return new Queue("persons_error_queue", true);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange("direct_exchange");
  }

  @Bean
  public Binding bindDirectExchangePersonQueue(Queue personQueue, DirectExchange directExchange){
    return BindingBuilder.bind(personQueue).to(directExchange).with("person");
  }

  @Bean
  public Binding bindDirectExchangeErrorPersonsQueue(Queue errorPersonsQueue, DirectExchange directExchange){
    return BindingBuilder.bind(errorPersonsQueue).to(directExchange).with("person_error");
  }
}
