package com.example.demo.controller;

import com.example.demo.Dto.PagamentoDTO;
import com.example.demo.Mapper.PagamentoMapper;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //  GET ALL
    @GetMapping
    public List<PagamentoDTO> getAll() {
        return service.getAllPagamenti()
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET BY ID
    @GetMapping("/{id}")
    public PagamentoDTO getById(@PathVariable Long id) {
        Pagamento pagamento = service.getPagamentoById(id);
        return PagamentoMapper.toDTO(pagamento);
    }

    //  CREATE
    @PostMapping
    public PagamentoDTO create(@RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = PagamentoMapper.toEntity(pagamentoDTO);
        pagamento = service.createPagamento(pagamento);
        return PagamentoMapper.toDTO(pagamento);
    }

    //  UPDATE
    @PutMapping("/{id}")
    public PagamentoDTO update(@PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = PagamentoMapper.toEntity(pagamentoDTO);
        pagamento.setIdPagamento(id);
        pagamento = service.updatePagamento(id, pagamento);
        return PagamentoMapper.toDTO(pagamento);
    }

    //  DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePagamento(id);
    }

    //  GET BY STUDENTE ID
    @GetMapping("/studente/{studenteId}")
    public List<PagamentoDTO> getByStudente(@PathVariable Long studenteId) {
        Studente studente = new Studente();
        studente.setIdStudente(studenteId);
        return service.getPagamentiByStudente(studente)
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET BY DATE RANGE
    @GetMapping("/date-range")
    public List<PagamentoDTO> getByDateRange(@RequestParam(name = "startDate") String startDate,
                                             @RequestParam(name = "endDate") String endDate) throws ParseException {
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        return service.getPagamentiByDateRange(start, end)
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET BY METODO
    @GetMapping("/metodo")
    public List<PagamentoDTO> getByMetodoPagamento(@RequestParam String metodo) {
        return service.getPagamentiByMetodoPagamento(metodo)
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET BY STATO
    @GetMapping("/stato")
    public List<PagamentoDTO> getByStato(@RequestParam String stato) {
        return service.getPagamentiByStato(stato)
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET PAGAMENTI SOPRA UN IMPORTO
    @GetMapping("/importo-minimo")
    public List<PagamentoDTO> getPagamentiAboveImporto(@RequestParam BigDecimal importoMinimo) {
        return service.getPagamentiAboveImporto(importoMinimo)
                .stream()
                .map(PagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    //  GET TOTALE IMPORTO PER STUDENTE
    @GetMapping("/total/{studenteId}")
    public BigDecimal getTotalAmountByStudente(@PathVariable Long studenteId) {
        return service.getTotalAmountByStudente(studenteId);
    }

    //  GET TOTALE IMPORTO PER RANGE DATE
    @GetMapping("/total-range")
    public BigDecimal getTotalAmountByDateRange(@RequestParam(name = "startDate") String startDate,
                                                @RequestParam(name = "endDate") String endDate) throws ParseException {
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        return service.getTotalAmountByDateRange(start, end);
    }
}
