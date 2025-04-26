package com.example.demo.service;

import com.example.demo.model.Pagamento;
import com.example.demo.model.Studente;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PagamentoService {
    List<Pagamento> getAllPagamenti();
    Pagamento getPagamentoById(Long id);
    Pagamento createPagamento(Pagamento pagamento);
    Pagamento updatePagamento(Long id, Pagamento pagamento);
    void deletePagamento(Long id);

    List<Pagamento> getPagamentiByStudente(Studente studente);
    List<Pagamento> getPagamentiByDateRange(Date startDate, Date endDate);
    List<Pagamento> getPagamentiByMetodoPagamento(String metodoPagamento);
    List<Pagamento> getPagamentiByStato(String stato);
    List<Pagamento> getPagamentiAboveImporto(BigDecimal importoMinimo);
    
    BigDecimal getTotalAmountByStudente(Long studenteId);
    BigDecimal getTotalAmountByDateRange(Date startDate, Date endDate);
}
