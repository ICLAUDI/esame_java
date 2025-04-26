package com.example.demo.controller;

import com.example.demo.model.Stage;
import com.example.demo.model.Corso;
import com.example.demo.model.Partner;
import com.example.demo.model.Studente;
import com.example.demo.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stage")
public class StageController {

    @Autowired
    private StageService stageService;

    // Crea un nuovo stage
    @PostMapping
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) {
        Stage createdStage = stageService.createStage(stage);
        return ResponseEntity.ok(createdStage);
    }

    // Ottieni tutti gli stage
    @GetMapping
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    // Ottieni uno stage per ID
    @GetMapping("/{id}")
    public ResponseEntity<Stage> getStageById(@PathVariable Long id) {
        Optional<Stage> stage = stageService.getStageById(id);
        return stage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni stage per studente
    @GetMapping("/studente/{studenteId}")
    public List<Stage> getStagesByStudente(@PathVariable Long studenteId) {
        Studente studente = new Studente();
        studente.setIdStudente(studenteId);
        return stageService.getStagesByStudente(studente);
    }

    // Ottieni stage per corso
    @GetMapping("/corso/{corsoId}")
    public List<Stage> getStagesByCorso(@PathVariable Long corsoId) {
        Corso corso = new Corso();
        corso.setIdCorso(corsoId);
        return stageService.getStagesByCorso(corso);
    }

    // Ottieni stage per partner
    @GetMapping("/partner/{partnerId}")
    public List<Stage> getStagesByPartner(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setIdPartner(partnerId);
        return stageService.getStagesByPartner(partner);
    }

    // Ottieni stage in un range di date
    @GetMapping("/data-range")
    public List<Stage> getStagesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return stageService.getStagesByDateRange(startDate, endDate);
    }

    // Ottieni stage per stato retribuito
    @GetMapping("/retribuito")
    public List<Stage> getStagesByRetribuito(@RequestParam Boolean retribuito) {
        return stageService.getStagesByRetribuito(retribuito);
    }

    // Ottieni stage per ruolo
    @GetMapping("/ruolo")
    public List<Stage> getStagesByRuolo(@RequestParam String ruolo) {
        return stageService.getStagesByRuolo(ruolo);
    }

    // Aggiorna uno stage esistente
    @PutMapping("/{id}")
    public ResponseEntity<Stage> updateStage(@PathVariable Long id, @RequestBody Stage stage) {
        Stage updatedStage = stageService.updateStage(id, stage);
        return updatedStage != null ? ResponseEntity.ok(updatedStage) : ResponseEntity.notFound().build();
    }

    // Elimina uno stage
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
        return ResponseEntity.noContent().build();
    }

    // Ottieni uno stage per corso e studente
    @GetMapping("/corso/{corsoId}/studente/{studenteId}")
    public ResponseEntity<Stage> getStageByCorsoAndStudente(@PathVariable Long corsoId, @PathVariable Long studenteId) {
        Corso corso = new Corso();
        corso.setIdCorso(corsoId);
        Studente studente = new Studente();
        studente.setIdStudente(studenteId);
        Stage stage = stageService.getStageByCorsoAndStudente(corso, studente);
        return stage != null ? ResponseEntity.ok(stage) : ResponseEntity.notFound().build();
    }

    // Ottieni stage attivi per data
    @GetMapping("/active")
    public List<Stage> getStagesByDateRangeForActive(@RequestParam Date dataFine, @RequestParam Date dataInizio) {
        return stageService.getStagesByDateRangeForActive(dataFine, dataInizio);
    }
}
