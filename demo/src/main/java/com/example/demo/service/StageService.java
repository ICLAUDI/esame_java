package com.example.demo.service;

import com.example.demo.model.Stage;

import java.util.List;

public interface StageService {
    Stage saveStage(Stage stage);
    Stage getStageById(Long id);
    List<Stage> getStagesByStudenteId(Long studenteId);
    List<Stage> getStagesByPartnerAziendaleId(Long partnerAziendaleId);
    List<Stage> getActiveStages();
    List<Stage> getCompletedStagesWithoutValutazione();
    void deleteStage(Long id);
    boolean existsById(Long id);
}
