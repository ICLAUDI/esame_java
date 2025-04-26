package com.example.demo.repository;

import com.example.demo.model.Feedback;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByStudente(Studente studente);
    List<Feedback> findByCorso(Corso corso);
    List<Feedback> findByValutazioneBetween(Integer minValutazione, Integer maxValutazione);
    List<Feedback> findByDataFeedbackBetween(Date startDate, Date endDate);
    
    @Query("SELECT AVG(f.valutazione) FROM Feedback f WHERE f.corso.idCorso = ?1")
    Double avgValutazioneByCorsoId(Long corsoId);
    
    Feedback findByCorsoAndStudente(Corso corso, Studente studente);
}
