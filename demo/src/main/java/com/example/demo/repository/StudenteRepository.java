package com.example.demo.repository;

import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
    List<Studente> findByNomeContainingIgnoreCase(String nome);
    List<Studente> findByCognomeContainingIgnoreCase(String cognome);
    Studente findByEmail(String email);
    List<Studente> findByDataIscrizioneBetween(Date startDate, Date endDate);
    List<Studente> findByTitoloStudioContainingIgnoreCase(String titoloStudio);
}