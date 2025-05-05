package com.example.demo.repository;

import com.example.demo.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    List<Docente> findByNomeContainingIgnoreCase(String nome);
    List<Docente> findByCognomeContainingIgnoreCase(String cognome);
    List<Docente> findBySpecializzazioneContainingIgnoreCase(String specializzazione);
    Optional<Docente> findByEmail(String email);
    List<Docente> findByRuolo(String ruolo);  // Aggiunto metodo per cercare per ruolo
}
