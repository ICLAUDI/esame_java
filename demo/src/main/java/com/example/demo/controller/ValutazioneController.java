package com.example.demo.controller;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Docente;
import com.example.demo.model.Valutazione;
import com.example.demo.service.ValutazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/valutazione")
public class ValutazioneController {

    @Autowired
    private ValutazioneService valutazioneService;

    // Crea una nuova valutazione
    @PostMapping
    public ResponseEntity<Valutazione> createValutazione(@RequestBody Valutazione valutazione) {
        Valutazione createdValutazione = valutazioneService.createValutazione(valutazione);
        return ResponseEntity.ok(createdValutazione);
    }

    // Ottieni tutte le valutazioni
    @GetMapping
    public List<Valutazione> getAllValutazioni() {
        return valutazioneService.getAllValutazioni();
    }

    // Ottieni una valutazione per ID
    @GetMapping("/{id}")
    public ResponseEntity<Valutazione> getValutazioneById(@PathVariable Long id) {
        Optional<Valutazione> valutazione = valutazioneService.getValutazioneById(id);
        return valutazione.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni valutazioni per iscrizione
    @GetMapping("/iscrizione/{idIscrizione}")
    public List<Valutazione> getValutazioniByIscrizione(@PathVariable Long idIscrizione) {
        Iscrizione iscrizione = new Iscrizione(); // Recupera l'oggetto Iscrizione con ID
        iscrizione.setIdIscrizione(idIscrizione);
        return valutazioneService.getValutazioniByIscrizione(iscrizione);
    }

    // Ottieni valutazioni per docente
    @GetMapping("/docente/{idDocente}")
    public List<Valutazione> getValutazioniByDocente(@PathVariable Long idDocente) {
        Docente docente = new Docente(); // Recupera l'oggetto Docente con ID
        docente.setIdDocente(idDocente);
        return valutazioneService.getValutazioniByDocente(docente);
    }

    // Ottieni valutazioni per voto
    @GetMapping("/voto")
    public List<Valutazione> getValutazioniByVotoRange(@RequestParam Integer minVoto, @RequestParam Integer maxVoto) {
        return valutazioneService.getValutazioniByVotoRange(minVoto, maxVoto);
    }

    // Ottieni valutazioni per data di valutazione
    @GetMapping("/data")
    public List<Valutazione> getValutazioniByDataValutazione(@RequestParam Date startDate, @RequestParam Date endDate) {
        return valutazioneService.getValutazioniByDataValutazione(startDate, endDate);
    }

    // Ottieni valutazioni per tipo di valutazione
    @GetMapping("/tipo")
    public List<Valutazione> getValutazioniByTipoValutazione(@RequestParam String tipoValutazione) {
        return valutazioneService.getValutazioniByTipoValutazione(tipoValutazione);
    }

    // Ottieni media dei voti per iscrizione
    @GetMapping("/media-iscrizione/{idIscrizione}")
    public ResponseEntity<Double> getAverageVotoByIscrizioneId(@PathVariable Long idIscrizione) {
        Double averageVoto = valutazioneService.getAverageVotoByIscrizioneId(idIscrizione);
        return ResponseEntity.ok(averageVoto);
    }

    // Ottieni media dei voti per corso
    @GetMapping("/media-corso/{idCorso}")
    public ResponseEntity<Double> getAverageVotoByCorsoId(@PathVariable Long idCorso) {
        Double averageVoto = valutazioneService.getAverageVotoByCorsoId(idCorso);
        return ResponseEntity.ok(averageVoto);
    }

    // Aggiorna una valutazione
    @PutMapping("/{id}")
    public ResponseEntity<Valutazione> updateValutazione(@PathVariable Long id, @RequestBody Valutazione valutazione) {
        Valutazione updatedValutazione = valutazioneService.updateValutazione(id, valutazione);
        return updatedValutazione != null ? ResponseEntity.ok(updatedValutazione) : ResponseEntity.notFound().build();
    }

    // Elimina una valutazione
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValutazione(@PathVariable Long id) {
        valutazioneService.deleteValutazione(id);
        return ResponseEntity.noContent().build();
    }
}
