package com.example.demo.service.impl;

import com.example.demo.model.Pagamento;
import com.example.demo.model.Studente;
import com.example.demo.repository.PagamentoRepository;
import com.example.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Override
    public List<Pagamento> getAllPagamenti() {
        return repository.findAll();
    }

    @Override
    public Pagamento getPagamentoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pagamento createPagamento(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    @Override
    public Pagamento updatePagamento(Long id, Pagamento pagamento) {
        pagamento.setIdPagamento(id);
        return repository.save(pagamento);
    }

    @Override
    public void deletePagamento(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pagamento> getPagamentiByStudente(Studente studente) {
        return repository.findByStudente(studente);
    }

    @Override
    public List<Pagamento> getPagamentiByDateRange(Date startDate, Date endDate) {
        return repository.findByDataPagamentoBetween(startDate, endDate);
    }

    @Override
    public List<Pagamento> getPagamentiByMetodoPagamento(String metodoPagamento) {
        return repository.findByMetodoPagamento(metodoPagamento);
    }

    @Override
    public List<Pagamento> getPagamentiByStato(String stato) {
        return repository.findByStato(stato);
    }

    @Override
    public List<Pagamento> getPagamentiAboveImporto(BigDecimal importoMinimo) {
        return repository.findByImportoGreaterThanEqual(importoMinimo);
    }

    @Override
    public BigDecimal getTotalAmountByStudente(Long studenteId) {
        return repository.sumImportoByStudenteId(studenteId);
    }

    @Override
    public BigDecimal getTotalAmountByDateRange(Date startDate, Date endDate) {
        return repository.sumImportoByDateRange(startDate, endDate);
    }
}
