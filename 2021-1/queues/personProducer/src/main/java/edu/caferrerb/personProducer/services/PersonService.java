package edu.caferrerb.personProducer.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import edu.caferrerb.personProducer.model.Person;
import edu.caferrerb.personProducer.producers.PersonQueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonQueueProducer personProducer;



    public void create(Person person) throws JsonProcessingException {
        personProducer.sendPerson(person);
    }
}
