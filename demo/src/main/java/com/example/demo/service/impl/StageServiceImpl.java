package com.example.demo.service.impl;

import com.example.demo.model.Stage;
import com.example.demo.model.Corso;
import com.example.demo.model.Partner;
import com.example.demo.model.Studente;
import com.example.demo.repository.StageRepository;
import com.example.demo.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StageServiceImpl implements StageService {

    @Autowired
    private StageRepository stageRepository;

    @Override
    public Stage createStage(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @Override
    public Optional<Stage> getStageById(Long id) {
        return stageRepository.findById(id);
    }

    @Override
    public List<Stage> getStagesByStudente(Studente studente) {
        return stageRepository.findByStudente(studente);
    }

    @Override
    public List<Stage> getStagesByCorso(Corso corso) {
        return stageRepository.findByCorso(corso);
    }

    @Override
    public List<Stage> getStagesByPartner(Partner partner) {
        return stageRepository.findByPartner(partner);
    }

    @Override
    public List<Stage> getStagesByDateRange(Date startDate, Date endDate) {
        return stageRepository.findByDataInizioBetween(startDate, endDate);
    }

    @Override
    public List<Stage> getStagesByRetribuito(Boolean retribuito) {
        return stageRepository.findByRetribuito(retribuito);
    }

    @Override
    public List<Stage> getStagesByRuolo(String ruolo) {
        return stageRepository.findByRuoloContainingIgnoreCase(ruolo);
    }

    @Override
    public Stage updateStage(Long id, Stage stage) {
        if (stageRepository.existsById(id)) {
            stage.setIdStage(id);
            return stageRepository.save(stage);
        }
        return null;
    }

    @Override
    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public Stage getStageByCorsoAndStudente(Corso corso, Studente studente) {
        return stageRepository.findByCorsoAndStudente(corso, studente);
    }

    @Override
    public List<Stage> getStagesByDateRangeForActive(Date dataFine, Date dataInizio) {
        return stageRepository.findByDataInizioLessThanEqualAndDataFineGreaterThanEqual(dataFine, dataInizio);
    }
}
