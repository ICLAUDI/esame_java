package com.example.demo.service;

import com.example.demo.model.Pagamento;

import java.time.LocalDate;
import java.util.List;

public interface PagamentoService {
    Pagamento savePagamento(Pagamento pagamento);
    Pagamento getPagamentoById(Long id);
    List<Pagamento> getPagamentiByStudenteId(Long studenteId);
    List<Pagamento> getPagamentiByStato(String statoPagamento);
    Double calculateTotalPagamentiByStudenteId(Long studenteId);
    List<Pagamento> getPagamentiInPeriodoOrderByImporto(LocalDate inizio, LocalDate fine);
    void deletePagamento(Long id);
    boolean existsById(Long id);
}
