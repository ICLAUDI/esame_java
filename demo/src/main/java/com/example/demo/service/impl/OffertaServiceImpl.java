package com.example.demo.service.impl;

import com.example.demo.model.Offerta;
import com.example.demo.repository.OffertaRepository;
import com.example.demo.service.OffertaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OffertaServiceImpl implements OffertaService {

    private final OffertaRepository offertaRepository;

    public OffertaServiceImpl(OffertaRepository offertaRepository) {
        this.offertaRepository = offertaRepository;
    }

    @Override
    public Offerta saveOfferta(Offerta offerta) {
        return offertaRepository.save(offerta);
    }

    @Override
    public Offerta getOffertaById(Long id) {
        return offertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offerta non trovata con id: " + id));
    }

    @Override
    public List<Offerta> getOfferteByTipo(String tipoOfferta) {
        return offertaRepository.findByTipoOfferta(tipoOfferta);
    }

    @Override
    public List<Offerta> getOfferteWithMoreThan50PercentDiscount() {
        return offertaRepository.findOfferteWithMoreThan50PercentDiscount();
    }

    @Override
    public List<Offerta> getActiveOfferteByCorsoId(Long corsoId) {
        return offertaRepository.findActiveOfferteByCorsoIdOrderByPrice(corsoId);
    }

    @Override
    public List<Offerta> getOfferteByScadenzaAfter(LocalDate today) {
        return offertaRepository.findByScadenzaAfter(today);
    }

    @Override
    public void deleteOfferta(Long id) {
        if (!offertaRepository.existsById(id)) {
            throw new RuntimeException("Offerta non trovata con id: " + id);
        }
        offertaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return offertaRepository.existsById(id);
    }
}
