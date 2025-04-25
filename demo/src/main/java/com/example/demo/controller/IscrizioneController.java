package com.example.demo.controller;

import com.example.demo.model.Iscrizione;
import com.example.demo.service.IscrizioneService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioneController {

    private final IscrizioneService iscrizioneService;

    public IscrizioneController(IscrizioneService iscrizioneService) {
        this.iscrizioneService = iscrizioneService;
    }

    @PostMapping
    public Iscrizione createIscrizione(@RequestBody Iscrizione iscrizione) {
        return iscrizioneService.saveIscrizione(iscrizione);
    }

    @GetMapping("/{id}")
    public Iscrizione getIscrizioneById(@PathVariable Long id) {
        return iscrizioneService.getIscrizioneById(id);
    }

    @GetMapping("/studente/{studenteId}/corso/{corsoId}")
    public List<Iscrizione> getIscrizioniByStudenteIdAndCorsoId(@PathVariable Long studenteId, @PathVariable Long corsoId) {
        return iscrizioneService.getIscrizioniByStudenteIdAndCorsoId(studenteId, corsoId);
    }

    @GetMapping("/periodo")
    public List<Iscrizione> getIscrizioniByPeriodo(@RequestParam LocalDate inizio, @RequestParam LocalDate fine) {
        return iscrizioneService.getIscrizioniByDataIscrizioneBetween(inizio, fine);
    }

    @GetMapping("/attive/studente/{studenteId}")
    public List<Iscrizione> getActiveIscrizioniByStudenteId(@PathVariable Long studenteId) {
        return iscrizioneService.getActiveIscrizioniByStudenteId(studenteId);
    }

    @GetMapping("/corso/{corsoId}/count")
    public Long countIscrizioniByCorsoId(@PathVariable Long corsoId) {
        return iscrizioneService.countIscrizioniByCorsoId(corsoId);
    }

    @DeleteMapping("/{id}")
    public void deleteIscrizione(@PathVariable Long id) {
        iscrizioneService.deleteIscrizione(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return iscrizioneService.existsById(id);
    }
}
