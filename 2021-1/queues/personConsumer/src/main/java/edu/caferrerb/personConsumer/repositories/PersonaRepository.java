package edu.caferrerb.personConsumer.repositories;

import edu.caferrerb.personConsumer.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
}
