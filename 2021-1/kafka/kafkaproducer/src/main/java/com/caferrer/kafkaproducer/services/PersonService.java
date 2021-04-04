package com.caferrer.kafkaproducer.services;


import com.caferrer.kafkaproducer.model.Person;
import com.caferrer.kafkaproducer.producers.PersonProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonProducer personProducer;



    public void create(Person person) throws JsonProcessingException {
        personProducer.sendPerson(person);
    }
}
