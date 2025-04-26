package com.example.demo.controller;

import com.example.demo.model.Pagamento;
import com.example.demo.model.Studente;
import com.example.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping
    public List<Pagamento> getAll() {
        return service.getAllPagamenti();
    }

    @GetMapping("/{id}")
    public Pagamento getById(@PathVariable Long id) {
        return service.getPagamentoById(id);
    }

    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento) {
        return service.createPagamento(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return service.updatePagamento(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePagamento(id);
    }

    @GetMapping("/studente/{studenteId}")
    public List<Pagamento> getByStudente(@PathVariable Long studenteId) {
        Studente studente = new Studente();  
        studente.setIdStudente(studenteId);
        return service.getPagamentiByStudente(studente);
    }

    @GetMapping("/date-range")
    public List<Pagamento> getByDateRange(@RequestParam(name = "startDate") String startDate,
                                          @RequestParam(name = "endDate") String endDate) throws ParseException {
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        return service.getPagamentiByDateRange(start, end);
    }

    @GetMapping("/metodo")
    public List<Pagamento> getByMetodoPagamento(@RequestParam String metodo) {
        return service.getPagamentiByMetodoPagamento(metodo);
    }

    @GetMapping("/stato")
    public List<Pagamento> getByStato(@RequestParam String stato) {
        return service.getPagamentiByStato(stato);
    }

    @GetMapping("/importo-minimo")
    public List<Pagamento> getPagamentiAboveImporto(@RequestParam BigDecimal importoMinimo) {
        return service.getPagamentiAboveImporto(importoMinimo);
    }

    @GetMapping("/total/{studenteId}")
    public BigDecimal getTotalAmountByStudente(@PathVariable Long studenteId) {
        return service.getTotalAmountByStudente(studenteId);
    }

    @GetMapping("/total-range")
    public BigDecimal getTotalAmountByDateRange(@RequestParam(name = "startDate") String startDate,
                                                @RequestParam(name = "endDate") String endDate) throws ParseException {
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        return service.getTotalAmountByDateRange(start, end);
    }
}
