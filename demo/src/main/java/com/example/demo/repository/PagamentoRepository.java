package com.example.demo.repository;

import com.example.demo.model.Pagamento;
import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByStudente(Studente studente);
    List<Pagamento> findByDataPagamentoBetween(Date startDate, Date endDate);
    List<Pagamento> findByMetodoPagamento(String metodoPagamento);
    List<Pagamento> findByStato(String stato);
    List<Pagamento> findByImportoGreaterThanEqual(BigDecimal importoMinimo);
    
    @Query("SELECT SUM(p.importo) FROM Pagamento p WHERE p.studente.idStudente = ?1")
    BigDecimal sumImportoByStudenteId(Long studenteId);
    
    @Query("SELECT SUM(p.importo) FROM Pagamento p WHERE p.dataPagamento BETWEEN ?1 AND ?2")
    BigDecimal sumImportoByDateRange(Date startDate, Date endDate);
}
