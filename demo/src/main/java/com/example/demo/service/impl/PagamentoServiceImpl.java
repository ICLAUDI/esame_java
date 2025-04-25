package com.example.demo.service.impl;

import com.example.demo.model.Pagamento;
import com.example.demo.repository.PagamentoRepository;
import com.example.demo.service.PagamentoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento savePagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Pagamento getPagamentoById(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento non trovato con id: " + id));
    }

    @Override
    public List<Pagamento> getPagamentiByStudenteId(Long studenteId) {
        return pagamentoRepository.findByStudenteId(studenteId);
    }

    @Override
    public List<Pagamento> getPagamentiByStato(String statoPagamento) {
        return pagamentoRepository.findByStatoPagamento(statoPagamento);
    }

    @Override
    public Double calculateTotalPagamentiByStudenteId(Long studenteId) {
        return pagamentoRepository.calculateTotalPagamentiByStudenteId(studenteId);
    }

    @Override
    public List<Pagamento> getPagamentiInPeriodoOrderByImporto(LocalDate inizio, LocalDate fine) {
        return pagamentoRepository.findPagamentiInPeriodoOrderByImporto(inizio, fine);
    }

    @Override
    public void deletePagamento(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            throw new RuntimeException("Pagamento non trovato con id: " + id);
        }
        pagamentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pagamentoRepository.existsById(id);
    }
}
