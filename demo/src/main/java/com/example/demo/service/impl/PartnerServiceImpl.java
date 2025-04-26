package com.example.demo.service.impl;

import com.example.demo.model.Partner;
import com.example.demo.repository.PartnerRepository;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    @Override
    public Optional<Partner> getPartnerById(Long id) {
        return partnerRepository.findById(id);
    }

    @Override
    public List<Partner> getPartnerByNomeAzienda(String nomeAzienda) {
        return partnerRepository.findByNomeAziendaContainingIgnoreCase(nomeAzienda);
    }

    @Override
    public List<Partner> getPartnerBySettore(String settore) {
        return partnerRepository.findBySettoreContainingIgnoreCase(settore);
    }

    @Override
    public List<Partner> getPartnerByReferente(String referente) {
        return partnerRepository.findByReferenteContainingIgnoreCase(referente);
    }

    @Override
    public Partner updatePartner(Long id, Partner partner) {
        if (partnerRepository.existsById(id)) {
            partner.setIdPartner(id);
            return partnerRepository.save(partner);
        }
        return null;
    }

    @Override
    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }
}
