package com.example.demo.repository;

import com.example.demo.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByNomeAziendaContainingIgnoreCase(String nomeAzienda);
    List<Partner> findBySettoreContainingIgnoreCase(String settore);
    List<Partner> findByReferenteContainingIgnoreCase(String referente);
}