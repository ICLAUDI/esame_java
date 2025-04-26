package com.example.demo.controller;

import com.example.demo.model.Offerta;
import com.example.demo.service.OffertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/offerte")
public class OffertaController {

    @Autowired
    private OffertaService service;

    @GetMapping
    public List<Offerta> getAll() {
        return service.getAllOfferte();
    }

    @GetMapping("/{id}")
    public Offerta getById(@PathVariable Long id) {
        return service.getOffertaById(id);
    }

    @PostMapping
    public Offerta create(@RequestBody Offerta offerta) {
        return service.createOfferta(offerta);
    }

    @PutMapping("/{id}")
    public Offerta update(@PathVariable Long id, @RequestBody Offerta offerta) {
        return service.updateOfferta(id, offerta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOfferta(id);
    }

    @GetMapping("/attive")
    public List<Offerta> getAttive(@RequestParam(name = "data") String data) {
        return service.getOfferteAttive(LocalDate.parse(data));
    }

    @GetMapping("/tipo")
    public List<Offerta> getByTipo(@RequestParam String tipo) {
        return service.getOfferteByTipo(tipo);
    }

    @GetMapping("/super-sconto")
    public List<Offerta> getOfferteScontate() {
        return service.getOfferteConScontoMaggioreDel50();
    }

    @GetMapping("/partner/{partnerId}")
    public List<Offerta> getByPartner(@PathVariable Long partnerId) {
        return service.getOfferteAttivePerPartner(partnerId);
    }
}
