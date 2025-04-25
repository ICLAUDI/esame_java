package com.example.demo.service.impl;

import com.example.demo.model.Stage;
import com.example.demo.repository.StageRepository;
import com.example.demo.service.StageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {

    private final StageRepository stageRepository;

    public StageServiceImpl(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @Override
    public Stage saveStage(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public Stage getStageById(Long id) {
        return stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage non trovato con id: " + id));
    }

    @Override
    public List<Stage> getStagesByStudenteId(Long studenteId) {
        return stageRepository.findByStudenteId(studenteId);
    }

    @Override
    public List<Stage> getStagesByPartnerAziendaleId(Long partnerAziendaleId) {
        return stageRepository.findByPartnerAziendaleId(partnerAziendaleId);
    }

    @Override
    public List<Stage> getActiveStages() {
        return stageRepository.findActiveStage();
    }

    @Override
    public List<Stage> getCompletedStagesWithoutValutazione() {
        return stageRepository.findCompletedStageWithoutValutazione();
    }

    @Override
    public void deleteStage(Long id) {
        if (!stageRepository.existsById(id)) {
            throw new RuntimeException("Stage non trovato con id: " + id);
        }
        stageRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return stageRepository.existsById(id);
    }
}
