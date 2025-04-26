package com.example.demo.controller;

import com.example.demo.model.Lezione;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Aula;
import com.example.demo.service.LezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/lezioni")
public class LezioneController {

    @Autowired
    private LezioneService lezioneService;

    @GetMapping
    public List<Lezione> getAll() {
        return lezioneService.getAllLezioni();
    }

    @GetMapping("/{id}")
    public Lezione getById(@PathVariable Long id) {
        return lezioneService.getLezioneById(id);
    }

    @PostMapping
    public Lezione create(@RequestBody Lezione lezione) {
        return lezioneService.createLezione(lezione);
    }

    @PutMapping("/{id}")
    public Lezione update(@PathVariable Long id, @RequestBody Lezione lezione) {
        return lezioneService.updateLezione(id, lezione);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lezioneService.deleteLezione(id);
    }

    @PostMapping("/corso")
    public List<Lezione> getByCorso(@RequestBody Corso corso) {
        return lezioneService.getByCorso(corso);
    }

    @PostMapping("/docente")
    public List<Lezione> getByDocente(@RequestBody Docente docente) {
        return lezioneService.getByDocente(docente);
    }

    @PostMapping("/aula")
    public List<Lezione> getByAula(@RequestBody Aula aula) {
        return lezioneService.getByAula(aula);
    }

    @GetMapping("/data")
    public List<Lezione> getByData(@RequestParam Date data) {
        return lezioneService.getByData(data);
    }

    @GetMapping("/data-range")
    public List<Lezione> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return lezioneService.getByDataBetween(start, end);
    }

    @GetMapping("/argomento")
    public List<Lezione> getByArgomento(@RequestParam String argomento) {
        return lezioneService.getByArgomento(argomento);
    }

    @PostMapping("/check-overlap")
    public List<Lezione> checkTimeOverlap(
            @RequestParam Long aulaId,
            @RequestParam Date data,
            @RequestParam String oraInizio,
            @RequestParam String oraFine
    ) {
        Aula aula = new Aula();
        aula.setIdAula(aulaId);
        return lezioneService.getByAulaAndDataAndTimeOverlap(aula, data, oraFine, oraInizio);
    }
}
