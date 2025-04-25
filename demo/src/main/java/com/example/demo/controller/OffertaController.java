package com.example.demo.controller;

import com.example.demo.model.Offerta;
import com.example.demo.service.OffertaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/offerte")
public class OffertaController {

    private final OffertaService offertaService;

    public OffertaController(OffertaService offertaService) {
        this.offertaService = offertaService;
    }

    @PostMapping
    public Offerta createOfferta(@RequestBody Offerta offerta) {
        return offertaService.saveOfferta(offerta);
    }

    @GetMapping("/{id}")
    public Offerta getOffertaById(@PathVariable Long id) {
        return offertaService.getOffertaById(id);
    }

    @GetMapping("/tipo/{tipoOfferta}")
    public List<Offerta> getOfferteByTipo(@PathVariable String tipoOfferta) {
        return offertaService.getOfferteByTipo(tipoOfferta);
    }

    @GetMapping("/scadenza")
    public List<Offerta> getOfferteByScadenza(@RequestParam LocalDate today) {
        return offertaService.getOfferteByScadenzaAfter(today);
    }

    @GetMapping("/sconto")
    public List<Offerta> getOfferteWithMoreThan50PercentDiscount() {
        return offertaService.getOfferteWithMoreThan50PercentDiscount();
    }

    @GetMapping("/corso/{corsoId}")
    public List<Offerta> getActiveOfferteByCorsoId(@PathVariable Long corsoId) {
        return offertaService.getActiveOfferteByCorsoId(corsoId);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferta(@PathVariable Long id) {
        offertaService.deleteOfferta(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return offertaService.existsById(id);
    }
}
