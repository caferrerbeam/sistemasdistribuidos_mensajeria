package com.caferrer.kafkaproducer.producers;

import com.caferrer.kafkaproducer.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendPerson(Person person) throws JsonProcessingException {
        kafkaTemplate.send("4pduc1fi-persons", objectMapper.writeValueAsString(person));
    }
}
