package edu.caferrerb.personConsumer.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue personsQueue() {
        return new Queue("persons_queue", true);
    }
}
