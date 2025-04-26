package com.example.demo.repository;

import com.example.demo.model.Presenza;
import com.example.demo.model.Lezione;
import com.example.demo.model.Iscrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenzaRepository extends JpaRepository<Presenza, Long> {
    List<Presenza> findByLezione(Lezione lezione);
    List<Presenza> findByIscrizione(Iscrizione iscrizione);
    List<Presenza> findByPresente(Boolean presente);
    
    Presenza findByLezioneAndIscrizione(Lezione lezione, Iscrizione iscrizione);
    
    @Query("SELECT COUNT(p) FROM Presenza p WHERE p.iscrizione.idIscrizione = ?1 AND p.presente = true")
    Integer countPresencesByIscrizioneId(Long iscrizioneId);
    
    @Query("SELECT COUNT(p) FROM Presenza p WHERE p.lezione.idLezione = ?1 AND p.presente = true")
    Integer countPresencesByLezioneId(Long lezioneId);
}
