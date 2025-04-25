package com.example.demo.repository;

import com.example.demo.model.Docente;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    List<Docente> findBySpecializzazione(String specializzazione);
    Optional<Docente> findByEmail(String email);
    @Query("SELECT d FROM Docente d JOIN d.corsi c GROUP BY d ORDER BY COUNT(c) DESC")
    List<Docente> findAllOrderByNumeroCorsi();
    @Query("SELECT d FROM Docente d WHERE SIZE(d.corsi) = (SELECT MAX(SIZE(doc.corsi)) FROM Docente doc)")
    List<Docente> findDocentiWithMostCorsi();
}