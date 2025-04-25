package com.example.demo.repository;

import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
    
    Studente findByEmail(String email);
    Studente findByNomeAndCognome(String nome, String cognome);
    
    List<Studente> findByTitoloStudio(String titoloStudio);
    List<Studente> findByDataIscrizioneAfter(LocalDate data);
    List<Studente> findByEmailContaining(String emailDomain);
    
    @Query("SELECT s FROM Studente s WHERE SIZE(s.iscrizioni) > :numeroMinimo")
    List<Studente> findStudentiWithMoreThanXIscrizioni(int numeroMinimo);
}