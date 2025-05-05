package com.example.demo.controller;

import com.example.demo.Dto.ValutazioneDTO;
import com.example.demo.Mapper.ValutazioneMapper;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/valutazione")
public class ValutazioneController {

    @Autowired
    private ValutazioneService valutazioneService;

    // Crea una nuova valutazione
    @PostMapping
    public ResponseEntity<ValutazioneDTO> createValutazione(@RequestBody ValutazioneDTO valutazioneDTO) {
        // Mappa il DTO alla entità
        Valutazione valutazione = ValutazioneMapper.toEntity(valutazioneDTO);
        // Salva la valutazione
        Valutazione createdValutazione = valutazioneService.createValutazione(valutazione);
        // Mappa l'entità salvata al DTO e restituisci la risposta
        ValutazioneDTO createdDTO = ValutazioneMapper.toDTO(createdValutazione);
        return ResponseEntity.ok(createdDTO);
    }

    // Ottieni tutte le valutazioni
    @GetMapping
    public List<ValutazioneDTO> getAllValutazioni() {
        // Ottieni tutte le valutazioni dal servizio
        List<Valutazione> valutazioni = valutazioneService.getAllValutazioni();
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni una valutazione per ID
    @GetMapping("/{id}")
    public ResponseEntity<ValutazioneDTO> getValutazioneById(@PathVariable Long id) {
        // Ottieni la valutazione dal servizio
        Optional<Valutazione> valutazione = valutazioneService.getValutazioneById(id);
        // Se la valutazione esiste, restituisci il DTO, altrimenti restituisci una risposta 404
        return valutazione.map(v -> ResponseEntity.ok(ValutazioneMapper.toDTO(v)))
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni valutazioni per iscrizione
    @GetMapping("/iscrizione/{idIscrizione}")
    public List<ValutazioneDTO> getValutazioniByIscrizione(@PathVariable Long idIscrizione) {
        // Crea un oggetto Iscrizione con l'ID
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(idIscrizione);
        // Ottieni le valutazioni per l'iscrizione
        List<Valutazione> valutazioni = valutazioneService.getValutazioniByIscrizione(iscrizione);
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni valutazioni per docente
    @GetMapping("/docente/{idDocente}")
    public List<ValutazioneDTO> getValutazioniByDocente(@PathVariable Long idDocente) {
        // Crea un oggetto Docente con l'ID
        Docente docente = new Docente();
        docente.setIdDocente(idDocente);
        // Ottieni le valutazioni per il docente
        List<Valutazione> valutazioni = valutazioneService.getValutazioniByDocente(docente);
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni valutazioni per voto
    @GetMapping("/voto")
    public List<ValutazioneDTO> getValutazioniByVotoRange(@RequestParam Integer minVoto, @RequestParam Integer maxVoto) {
        // Ottieni le valutazioni per range di voto
        List<Valutazione> valutazioni = valutazioneService.getValutazioniByVotoRange(minVoto, maxVoto);
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni valutazioni per data di valutazione
    @GetMapping("/data")
    public List<ValutazioneDTO> getValutazioniByDataValutazione(@RequestParam Date startDate, @RequestParam Date endDate) {
        // Ottieni le valutazioni per il range di date
        List<Valutazione> valutazioni = valutazioneService.getValutazioniByDataValutazione(startDate, endDate);
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni valutazioni per tipo di valutazione
    @GetMapping("/tipo")
    public List<ValutazioneDTO> getValutazioniByTipoValutazione(@RequestParam String tipoValutazione) {
        // Ottieni le valutazioni per tipo
        List<Valutazione> valutazioni = valutazioneService.getValutazioniByTipoValutazione(tipoValutazione);
        // Mappa le valutazioni a DTO e restituisci la lista
        return valutazioni.stream()
                          .map(ValutazioneMapper::toDTO)
                          .collect(Collectors.toList());
    }

    // Ottieni media dei voti per iscrizione
    @GetMapping("/media-iscrizione/{idIscrizione}")
    public ResponseEntity<Double> getAverageVotoByIscrizioneId(@PathVariable Long idIscrizione) {
        // Calcola la media dei voti per l'iscrizione
        Double averageVoto = valutazioneService.getAverageVotoByIscrizioneId(idIscrizione);
        // Restituisci la media
        return ResponseEntity.ok(averageVoto);
    }

    // Ottieni media dei voti per corso
    @GetMapping("/media-corso/{idCorso}")
    public ResponseEntity<Double> getAverageVotoByCorsoId(@PathVariable Long idCorso) {
        // Calcola la media dei voti per il corso
        Double averageVoto = valutazioneService.getAverageVotoByCorsoId(idCorso);
        // Restituisci la media
        return ResponseEntity.ok(averageVoto);
    }

    // Aggiorna una valutazione
    @PutMapping("/{id}")
    public ResponseEntity<ValutazioneDTO> updateValutazione(@PathVariable Long id, @RequestBody ValutazioneDTO valutazioneDTO) {
        // Mappa il DTO a entità
        Valutazione valutazione = ValutazioneMapper.toEntity(valutazioneDTO);
        // Aggiorna la valutazione
        Valutazione updatedValutazione = valutazioneService.updateValutazione(id, valutazione);
        // Restituisci il DTO aggiornato, oppure 404 se non trovato
        return updatedValutazione != null ? ResponseEntity.ok(ValutazioneMapper.toDTO(updatedValutazione))
                                          : ResponseEntity.notFound().build();
    }

    // Elimina una valutazione
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValutazione(@PathVariable Long id) {
        // Elimina la valutazione
        valutazioneService.deleteValutazione(id);
        // Restituisci una risposta senza contenuto
        return ResponseEntity.noContent().build();
    }
}
