package com.example.demo.repository;

import com.example.demo.model.Stage;
import com.example.demo.model.Corso;
import com.example.demo.model.Partner;
import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    List<Stage> findByStudente(Studente studente);
    List<Stage> findByCorso(Corso corso);
    List<Stage> findByPartner(Partner partner);
    List<Stage> findByDataInizioBetween(Date startDate, Date endDate);
    List<Stage> findByDataFineBetween(Date startDate, Date endDate);
    List<Stage> findByRetribuito(Boolean retribuito);
    List<Stage> findByRuoloContainingIgnoreCase(String ruolo);
    
    Stage findByCorsoAndStudente(Corso corso, Studente studente);
    List<Stage> findByDataInizioLessThanEqualAndDataFineGreaterThanEqual(Date dataFine, Date dataInizio);
}