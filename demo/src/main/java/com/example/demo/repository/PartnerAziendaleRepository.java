package com.example.demo.repository;

import com.example.demo.model.PartnerAziendale;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartnerAziendaleRepository extends JpaRepository<PartnerAziendale, Long> {
    List<PartnerAziendale> findBySettore(String settore);
    Optional<PartnerAziendale> findByPartitaIva(String partitaIva);
    @Query("SELECT p FROM PartnerAziendale p JOIN p.stage s GROUP BY p ORDER BY COUNT(s) DESC")
    List<PartnerAziendale> findAllOrderByNumeroStage();
    @Query("SELECT p FROM PartnerAziendale p WHERE p.dataConvenzione > :data")
    List<PartnerAziendale> findPartnerWithRecentConvenzione(LocalDate data);
}