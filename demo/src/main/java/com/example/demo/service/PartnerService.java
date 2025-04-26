package com.example.demo.service;

import com.example.demo.model.Partner;

import java.util.List;
import java.util.Optional;

public interface PartnerService {
    Partner createPartner(Partner partner);
    List<Partner> getAllPartners();
    Optional<Partner> getPartnerById(Long id);
    List<Partner> getPartnerByNomeAzienda(String nomeAzienda);
    List<Partner> getPartnerBySettore(String settore);
    List<Partner> getPartnerByReferente(String referente);
    Partner updatePartner(Long id, Partner partner);
    void deletePartner(Long id);
}
