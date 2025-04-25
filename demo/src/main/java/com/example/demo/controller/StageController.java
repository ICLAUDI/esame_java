package com.example.demo.controller;

import com.example.demo.model.Stage;
import com.example.demo.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stage")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }
    
    @PostMapping
    public Stage createStage(@RequestBody Stage stage) {
        return stageService.saveStage(stage);
    }

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable Long id) {
        return stageService.getStageById(id);
    }

    @GetMapping("/studente/{studenteId}")
    public List<Stage> getStagesByStudenteId(@PathVariable Long studenteId) {
        return stageService.getStagesByStudenteId(studenteId);
    }

    @GetMapping("/partner/{partnerAziendaleId}")
    public List<Stage> getStagesByPartnerAziendaleId(@PathVariable Long partnerAziendaleId) {
        return stageService.getStagesByPartnerAziendaleId(partnerAziendaleId);
    }

    @GetMapping("/attivi")
    public List<Stage> getActiveStages() {
        return stageService.getActiveStages();
    }

    @GetMapping("/completati-senza-valutazione")
    public List<Stage> getCompletedStagesWithoutValutazione() {
        return stageService.getCompletedStagesWithoutValutazione();
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return stageService.existsById(id);
    }
}
