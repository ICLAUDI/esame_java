package com.example.demo.controller;

import com.example.demo.model.Presenza;
import com.example.demo.model.Lezione;
import com.example.demo.model.Iscrizione;
import com.example.demo.service.PresenzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/presenze")
public class PresenzaController {

    @Autowired
    private PresenzaService presenzaService;

    // Crea una nuova presenza
    @PostMapping
    public ResponseEntity<Presenza> createPresenza(@RequestBody Presenza presenza) {
        Presenza createdPresenza = presenzaService.createPresenza(presenza);
        return ResponseEntity.ok(createdPresenza);
    }

    // Ottieni tutte le presenze
    @GetMapping
    public List<Presenza> getAllPresenze() {
        return presenzaService.getAllPresenze();
    }

    // Ottieni una presenza per ID
    @GetMapping("/{id}")
    public ResponseEntity<Presenza> getPresenzaById(@PathVariable Long id) {
        Optional<Presenza> presenza = presenzaService.getPresenzaById(id);
        return presenza.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni presenze per lezione
    @GetMapping("/lezione/{lezioneId}")
    public List<Presenza> getPresenzeByLezione(@PathVariable Long lezioneId) {
        Lezione lezione = new Lezione();
        lezione.setIdLezione(lezioneId);
        return presenzaService.getPresenzeByLezione(lezione);
    }

    // Ottieni presenze per iscrizione
    @GetMapping("/iscrizione/{iscrizioneId}")
    public List<Presenza> getPresenzeByIscrizione(@PathVariable Long iscrizioneId) {
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(iscrizioneId);
        return presenzaService.getPresenzeByIscrizione(iscrizione);
    }

    // Ottieni presenze per stato (presente o assente)
    @GetMapping("/presenza")
    public List<Presenza> getPresenzeByPresenza(@RequestParam Boolean presente) {
        return presenzaService.getPresenzeByPresenza(presente);
    }

    // Ottieni presenza per lezione e iscrizione
    @GetMapping("/lezione/{lezioneId}/iscrizione/{iscrizioneId}")
    public ResponseEntity<Presenza> getPresenzaByLezioneAndIscrizione(@PathVariable Long lezioneId,
                                                                      @PathVariable Long iscrizioneId) {
        Lezione lezione = new Lezione();
        lezione.setIdLezione(lezioneId);
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(iscrizioneId);
        Presenza presenza = presenzaService.getPresenzaByLezioneAndIscrizione(lezione, iscrizione);
        return presenza != null ? ResponseEntity.ok(presenza) : ResponseEntity.notFound().build();
    }

    // Conta le presenze per iscrizione
    @GetMapping("/count/iscrizione/{iscrizioneId}")
    public Integer countPresenzeByIscrizione(@PathVariable Long iscrizioneId) {
        return presenzaService.countPresenzeByIscrizioneId(iscrizioneId);
    }

    // Conta le presenze per lezione
    @GetMapping("/count/lezione/{lezioneId}")
    public Integer countPresenzeByLezione(@PathVariable Long lezioneId) {
        return presenzaService.countPresenzeByLezioneId(lezioneId);
    }

    // Aggiorna una presenza esistente
    @PutMapping("/{id}")
    public ResponseEntity<Presenza> updatePresenza(@PathVariable Long id, @RequestBody Presenza presenza) {
        Presenza updatedPresenza = presenzaService.updatePresenza(id, presenza);
        return updatedPresenza != null ? ResponseEntity.ok(updatedPresenza) : ResponseEntity.notFound().build();
    }

    // Elimina una presenza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresenza(@PathVariable Long id) {
        presenzaService.deletePresenza(id);
        return ResponseEntity.noContent().build();
    }
}
