package com.example.demo.repository;

import com.example.demo.model.Lezione;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LezioneRepository extends JpaRepository<Lezione, Long> {
    List<Lezione> findByCorso(Corso corso);
    List<Lezione> findByDocente(Docente docente);
    List<Lezione> findByAula(Aula aula);
    List<Lezione> findByData(Date data);
    List<Lezione> findByDataBetween(Date startDate, Date endDate);
    List<Lezione> findByArgomentoContainingIgnoreCase(String argomento);
    
    List<Lezione> findByAulaAndDataAndOraInizioLessThanEqualAndOraFineGreaterThanEqual(
        Aula aula, Date data, String oraFine, String oraInizio);
}