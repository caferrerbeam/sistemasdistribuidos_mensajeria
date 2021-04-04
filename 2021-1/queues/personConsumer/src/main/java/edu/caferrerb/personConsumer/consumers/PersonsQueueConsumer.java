package edu.caferrerb.personConsumer.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.caferrerb.personConsumer.model.entities.Persona;
import edu.caferrerb.personConsumer.model.msj.PersonMessage;
import edu.caferrerb.personConsumer.services.PersonaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonsQueueConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonaService personaService;

    @RabbitListener( queues = "persons_queue")
    public void listenPersonsQueue(String message) throws JsonProcessingException {
        System.out.println(message);

        PersonMessage p = objectMapper.readValue(message, PersonMessage.class);

        personaService.create(new Persona(p.getCedula(), p.getCedula(), p.getEmail()));
    }
}

