package edu.caferrerb.personProducer.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.caferrerb.personProducer.model.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonQueueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendPerson(Person person) throws JsonProcessingException {

        String message = objectMapper.writeValueAsString(person);

        rabbitTemplate.convertAndSend("persons_queue", message);
    }
}
