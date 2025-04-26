package com.example.demo.controller;

import com.example.demo.model.Iscrizione;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import com.example.demo.service.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioneController {

    @Autowired
    private IscrizioneService iscrizioneService;

    @GetMapping
    public List<Iscrizione> getAll() {
        return iscrizioneService.getAllIscrizioni();
    }

    @GetMapping("/{id}")
    public Iscrizione getById(@PathVariable Long id) {
        return iscrizioneService.getIscrizioneById(id);
    }

    @PostMapping
    public Iscrizione create(@RequestBody Iscrizione iscrizione) {
        return iscrizioneService.createIscrizione(iscrizione);
    }

    @PutMapping("/{id}")
    public Iscrizione update(@PathVariable Long id, @RequestBody Iscrizione iscrizione) {
        return iscrizioneService.updateIscrizione(id, iscrizione);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iscrizioneService.deleteIscrizione(id);
    }

    @PostMapping("/studente")
    public List<Iscrizione> getByStudente(@RequestBody Studente studente) {
        return iscrizioneService.getByStudente(studente);
    }

    @PostMapping("/corso")
    public List<Iscrizione> getByCorso(@RequestBody Corso corso) {
        return iscrizioneService.getByCorso(corso);
    }

    @GetMapping("/date")
    public List<Iscrizione> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return iscrizioneService.getByDateRange(start, end);
    }

    @GetMapping("/stato")
    public List<Iscrizione> getByStato(@RequestParam String stato) {
        return iscrizioneService.getByStato(stato);
    }

    @GetMapping("/completato")
    public List<Iscrizione> getByCompletato(@RequestParam Boolean completato) {
        return iscrizioneService.getByCompletato(completato);
    }

    @GetMapping("/conta/{corsoId}")
    public Integer countByCorso(@PathVariable Long corsoId) {
        return iscrizioneService.countByCorsoId(corsoId);
    }

    @PostMapping("/studente-corso")
    public List<Iscrizione> getByStudenteAndCorso(@RequestBody Studente studente, @RequestBody Corso corso) {
        return iscrizioneService.getByStudenteAndCorso(studente, corso);
    }
}
