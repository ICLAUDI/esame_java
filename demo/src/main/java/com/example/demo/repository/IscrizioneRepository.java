package com.example.demo.repository;

import com.example.demo.model.Iscrizione;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {
    List<Iscrizione> findByStudente(Studente studente);
    List<Iscrizione> findByCorso(Corso corso);
    List<Iscrizione> findByDataIscrizioneBetween(Date startDate, Date endDate);
    List<Iscrizione> findByStato(String stato);
    List<Iscrizione> findByCompletato(Boolean completato);
    
    @Query("SELECT COUNT(i) FROM Iscrizione i WHERE i.corso.idCorso = ?1")
    Integer countByCorsoId(Long corsoId);
    
    List<Iscrizione> findByStudenteAndCorso(Studente studente, Corso corso);
}
