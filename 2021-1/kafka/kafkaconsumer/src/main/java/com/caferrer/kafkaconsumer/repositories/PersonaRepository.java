package com.caferrer.kafkaconsumer.repositories;

import com.caferrer.kafkaconsumer.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
}
