package com.example.demo.service;

import com.example.demo.model.PartnerAziendale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PartnerAziendaleService {
    PartnerAziendale savePartnerAziendale(PartnerAziendale partnerAziendale);
    PartnerAziendale getPartnerAziendaleById(Long id);
    Optional<PartnerAziendale> getPartnerAziendaleByPartitaIva(String partitaIva);
    List<PartnerAziendale> getPartnerAziendaleBySettore(String settore);
    List<PartnerAziendale> getAllPartnerAziendaliOrderedByNumeroStage();
    List<PartnerAziendale> getPartnerAziendaliWithRecentConvenzione(LocalDate data);
    void deletePartnerAziendale(Long id);
    boolean existsById(Long id);
}
