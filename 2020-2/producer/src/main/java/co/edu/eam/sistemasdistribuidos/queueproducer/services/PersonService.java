package co.edu.eam.sistemasdistribuidos.queueproducer.services;

import co.edu.eam.sistemasdistribuidos.queueproducer.model.requests.Person;
import co.edu.eam.sistemasdistribuidos.queueproducer.producers.PersonsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  private PersonsProducer personsProducer;

  public void createPerson(Person person) {
    try {
      personsProducer.producePerson(person);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

}
