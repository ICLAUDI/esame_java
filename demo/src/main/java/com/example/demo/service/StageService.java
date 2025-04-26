package com.example.demo.service;

import com.example.demo.model.Stage;
import com.example.demo.model.Corso;
import com.example.demo.model.Partner;
import com.example.demo.model.Studente;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StageService {
    Stage createStage(Stage stage);
    List<Stage> getAllStages();
    Optional<Stage> getStageById(Long id);
    List<Stage> getStagesByStudente(Studente studente);
    List<Stage> getStagesByCorso(Corso corso);
    List<Stage> getStagesByPartner(Partner partner);
    List<Stage> getStagesByDateRange(Date startDate, Date endDate);
    List<Stage> getStagesByRetribuito(Boolean retribuito);
    List<Stage> getStagesByRuolo(String ruolo);
    Stage updateStage(Long id, Stage stage);
    void deleteStage(Long id);
    Stage getStageByCorsoAndStudente(Corso corso, Studente studente);
    List<Stage> getStagesByDateRangeForActive(Date dataFine, Date dataInizio);
}
