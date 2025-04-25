package com.example.demo.service.impl;

import com.example.demo.model.PartnerAziendale;
import com.example.demo.repository.PartnerAziendaleRepository;
import com.example.demo.service.PartnerAziendaleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerAziendaleServiceImpl implements PartnerAziendaleService {

    private final PartnerAziendaleRepository partnerAziendaleRepository;

    public PartnerAziendaleServiceImpl(PartnerAziendaleRepository partnerAziendaleRepository) {
        this.partnerAziendaleRepository = partnerAziendaleRepository;
    }

    @Override
    public PartnerAziendale savePartnerAziendale(PartnerAziendale partnerAziendale) {
        return partnerAziendaleRepository.save(partnerAziendale);
    }

    @Override
    public PartnerAziendale getPartnerAziendaleById(Long id) {
        return partnerAziendaleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner aziendale non trovato con id: " + id));
    }

    @Override
    public Optional<PartnerAziendale> getPartnerAziendaleByPartitaIva(String partitaIva) {
        return partnerAziendaleRepository.findByPartitaIva(partitaIva);
    }

    @Override
    public List<PartnerAziendale> getPartnerAziendaleBySettore(String settore) {
        return partnerAziendaleRepository.findBySettore(settore);
    }

    @Override
    public List<PartnerAziendale> getAllPartnerAziendaliOrderedByNumeroStage() {
        return partnerAziendaleRepository.findAllOrderByNumeroStage();
    }

    @Override
    public List<PartnerAziendale> getPartnerAziendaliWithRecentConvenzione(LocalDate data) {
        return partnerAziendaleRepository.findPartnerWithRecentConvenzione(data);
    }

    @Override
    public void deletePartnerAziendale(Long id) {
        if (!partnerAziendaleRepository.existsById(id)) {
            throw new RuntimeException("Partner aziendale non trovato con id: " + id);
        }
        partnerAziendaleRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return partnerAziendaleRepository.existsById(id);
    }
}
