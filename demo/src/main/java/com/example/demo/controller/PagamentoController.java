package com.example.demo.controller;

import com.example.demo.model.Pagamento;
import com.example.demo.service.PagamentoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.savePagamento(pagamento);
    }

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable Long id) {
        return pagamentoService.getPagamentoById(id);
    }

    @GetMapping("/studente/{studenteId}")
    public List<Pagamento> getPagamentiByStudenteId(@PathVariable Long studenteId) {
        return pagamentoService.getPagamentiByStudenteId(studenteId);
    }

    @GetMapping("/stato/{statoPagamento}")
    public List<Pagamento> getPagamentiByStato(@PathVariable String statoPagamento) {
        return pagamentoService.getPagamentiByStato(statoPagamento);
    }

    @GetMapping("/totale/{studenteId}")
    public Double calculateTotalPagamenti(@PathVariable Long studenteId) {
        return pagamentoService.calculateTotalPagamentiByStudenteId(studenteId);
    }

    @GetMapping("/periodo")
    public List<Pagamento> getPagamentiInPeriodo(
            @RequestParam LocalDate inizio, 
            @RequestParam LocalDate fine) {
        return pagamentoService.getPagamentiInPeriodoOrderByImporto(inizio, fine);
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable Long id) {
        pagamentoService.deletePagamento(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return pagamentoService.existsById(id);
    }
}
