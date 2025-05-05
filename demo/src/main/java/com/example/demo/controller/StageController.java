package com.example.demo.controller;

import com.example.demo.Dto.StageDTO;
import com.example.demo.Mapper.StageMapper;
import com.example.demo.model.Corso;
import com.example.demo.model.Partner;
import com.example.demo.model.Studente;
import com.example.demo.model.Stage;
import com.example.demo.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stage")
public class StageController {

    @Autowired
    private StageService stageService;

    // Crea un nuovo stage
    @PostMapping
    public ResponseEntity<StageDTO> createStage(@RequestBody StageDTO stageDTO) {
        // Mappa il DTO in un'entità Stage
        Stage stage = StageMapper.toEntity(stageDTO);
        // Crea lo stage nel database
        Stage createdStage = stageService.createStage(stage);
        // Mappa l'entità Stage al DTO
        StageDTO createdStageDTO = StageMapper.toDTO(createdStage);
        // Restituisce il DTO come risposta
        return ResponseEntity.ok(createdStageDTO);
    }

    // Ottieni tutti gli stage
    @GetMapping
    public List<StageDTO> getAllStages() {
        List<Stage> stages = stageService.getAllStages();
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni uno stage per ID
    @GetMapping("/{id}")
    public ResponseEntity<StageDTO> getStageById(@PathVariable Long id) {
        Optional<Stage> stage = stageService.getStageById(id);
        // Se lo stage esiste, restituisci il DTO, altrimenti rispondi con 404 Not Found
        return stage.map(s -> ResponseEntity.ok(StageMapper.toDTO(s)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni stage per studente
    @GetMapping("/studente/{studenteId}")
    public List<StageDTO> getStagesByStudente(@PathVariable Long studenteId) {
        Studente studente = new Studente();
        studente.setIdStudente(studenteId);
        List<Stage> stages = stageService.getStagesByStudente(studente);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni stage per corso
    @GetMapping("/corso/{corsoId}")
    public List<StageDTO> getStagesByCorso(@PathVariable Long corsoId) {
        Corso corso = new Corso();
        corso.setIdCorso(corsoId);
        List<Stage> stages = stageService.getStagesByCorso(corso);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni stage per partner
    @GetMapping("/partner/{partnerId}")
    public List<StageDTO> getStagesByPartner(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setIdPartner(partnerId);
        List<Stage> stages = stageService.getStagesByPartner(partner);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni stage in un range di date
    @GetMapping("/data-range")
    public List<StageDTO> getStagesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<Stage> stages = stageService.getStagesByDateRange(startDate, endDate);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni stage per stato retribuito
    @GetMapping("/retribuito")
    public List<StageDTO> getStagesByRetribuito(@RequestParam Boolean retribuito) {
        List<Stage> stages = stageService.getStagesByRetribuito(retribuito);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Ottieni stage per ruolo
    @GetMapping("/ruolo")
    public List<StageDTO> getStagesByRuolo(@RequestParam String ruolo) {
        List<Stage> stages = stageService.getStagesByRuolo(ruolo);
        // Mappa ogni entità Stage in un StageDTO
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Aggiorna uno stage esistente
    @PutMapping("/{id}")
    public ResponseEntity<StageDTO> updateStage(@PathVariable Long id, @RequestBody StageDTO stageDTO) {
        // Mappa il DTO in un'entità Stage
        Stage stage = StageMapper.toEntity(stageDTO);
        // Prova ad aggiornare lo stage nel database
        Stage updatedStage = stageService.updateStage(id, stage);
        // Se lo stage è stato aggiornato, restituisci il DTO, altrimenti restituisci 404 Not Found
        return updatedStage != null ? ResponseEntity.ok(StageMapper.toDTO(updatedStage)) 
                                    : ResponseEntity.notFound().build();
    }

    // Elimina uno stage
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        // Elimina lo stage
        stageService.deleteStage(id);
        return ResponseEntity.noContent().build(); // Restituisce 204 No Content
    }

    // Ottieni uno stage per corso e studente
    @GetMapping("/corso/{corsoId}/studente/{studenteId}")
    public ResponseEntity<StageDTO> getStageByCorsoAndStudente(@PathVariable Long corsoId, @PathVariable Long studenteId) {
        Corso corso = new Corso();
        corso.setIdCorso(corsoId);
        Studente studente = new Studente();
        studente.setIdStudente(studenteId);
        Stage stage = stageService.getStageByCorsoAndStudente(corso, studente);
        return stage != null ? ResponseEntity.ok(StageMapper.toDTO(stage)) : ResponseEntity.notFound().build();
    }

    // Ottieni stage attivi per data
    @GetMapping("/active")
    public List<StageDTO> getStagesByDateRangeForActive(@RequestParam Date dataFine, @RequestParam Date dataInizio) {
        List<Stage> stages = stageService.getStagesByDateRangeForActive(dataFine, dataInizio);
        return stages.stream()
                     .map(StageMapper::toDTO)
                     .collect(Collectors.toList());
    }
}
