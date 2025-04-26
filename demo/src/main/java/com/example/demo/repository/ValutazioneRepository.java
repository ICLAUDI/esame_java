package com.example.demo.repository;

import com.example.demo.model.Valutazione;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ValutazioneRepository extends JpaRepository<Valutazione, Long> {
    List<Valutazione> findByIscrizione(Iscrizione iscrizione);
    List<Valutazione> findByDocente(Docente docente);
    List<Valutazione> findByVotoBetween(Integer minVoto, Integer maxVoto);
    List<Valutazione> findByDataValutazioneBetween(Date startDate, Date endDate);
    List<Valutazione> findByTipoValutazione(String tipoValutazione);
    
    @Query("SELECT AVG(v.voto) FROM Valutazione v WHERE v.iscrizione.idIscrizione = ?1")
    Double avgVotoByIscrizioneId(Long iscrizioneId);
    
    @Query("SELECT AVG(v.voto) FROM Valutazione v WHERE v.iscrizione.corso.idCorso = ?1")
    Double avgVotoByCorsoId(Long corsoId);
}