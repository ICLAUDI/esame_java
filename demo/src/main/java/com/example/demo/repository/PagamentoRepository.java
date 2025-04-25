package com.example.demo.repository;

import com.example.demo.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByStudenteId(Long studenteId);
    List<Pagamento> findByStatoPagamento(String statoPagamento);
    @Query("SELECT SUM(p.importo) FROM Pagamento p WHERE p.studente.id = :studenteId")
    Double calculateTotalPagamentiByStudenteId(Long studenteId);
    @Query("SELECT p FROM Pagamento p WHERE p.dataPagamento BETWEEN :inizio AND :fine ORDER BY p.importo DESC")
    List<Pagamento> findPagamentiInPeriodoOrderByImporto(LocalDate inizio, LocalDate fine);
}