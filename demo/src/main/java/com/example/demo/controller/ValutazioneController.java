package com.example.demo.controller;

import com.example.demo.model.Valutazione;
import com.example.demo.service.ValutazioneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valutazioni")
public class ValutazioneController {

    private final ValutazioneService valutazioneService;

    public ValutazioneController(ValutazioneService valutazioneService) {
        this.valutazioneService = valutazioneService;
    }

    @PostMapping
    public Valutazione createValutazione(@RequestBody Valutazione valutazione) {
        return valutazioneService.saveValutazione(valutazione);
    }

    @GetMapping("/{id}")
    public Valutazione getValutazioneById(@PathVariable Long id) {
        return valutazioneService.getValutazioneById(id);
    }

    @GetMapping("/studente/{studenteId}")
    public List<Valutazione> getValutazioniByStudenteId(@PathVariable Long studenteId) {
        return valutazioneService.getValutazioniByStudenteId(studenteId);
    }

    @GetMapping("/corso/{corsoId}")
    public List<Valutazione> getValutazioniByCorsoId(@PathVariable Long corsoId) {
        return valutazioneService.getValutazioniByCorsoId(corsoId);
    }

    @GetMapping("/corso/{corsoId}/media")
    public Double getAverageVotoByCorsoId(@PathVariable Long corsoId) {
        return valutazioneService.getAverageVotoByCorsoId(corsoId);
    }

    @GetMapping("/alta-valutazione/{votoMinimo}")
    public List<Valutazione> getValutazioniWithHighVoto(@PathVariable Double votoMinimo) {
        return valutazioneService.getValutazioniWithHighVoto(votoMinimo);
    }

    @DeleteMapping("/{id}")
    public void deleteValutazione(@PathVariable Long id) {
        valutazioneService.deleteValutazione(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return valutazioneService.existsById(id);
    }
}
