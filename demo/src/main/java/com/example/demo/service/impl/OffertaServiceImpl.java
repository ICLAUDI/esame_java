package com.example.demo.service.impl;

import com.example.demo.model.Offerta;
import com.example.demo.repository.OffertaRepository;
import com.example.demo.service.OffertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OffertaServiceImpl implements OffertaService {

    @Autowired
    private OffertaRepository repository;

    @Override
    public List<Offerta> getAllOfferte() {
        return repository.findAll();
    }

    @Override
    public Offerta getOffertaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Offerta createOfferta(Offerta offerta) {
        return repository.save(offerta);
    }

    @Override
    public Offerta updateOfferta(Long id, Offerta offerta) {
        offerta.setId_offerta(id);
        return repository.save(offerta);
    }

    @Override
    public void deleteOfferta(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Offerta> getOfferteAttive(LocalDate data) {
        return repository.findByDataScadenzaAfter(data);
    }

    @Override
    public List<Offerta> getOfferteByTipo(String tipoOfferta) {
        return repository.findByTipoOfferta(tipoOfferta);
    }

    @Override
    public List<Offerta> getOfferteConScontoMaggioreDel50() {
        return repository.findOfferteWithMoreThan50PercentDiscount();
    }

    @Override
    public List<Offerta> getOfferteAttivePerPartner(Long partnerId) {
        return repository.findActiveOfferteByPartnerIdOrderByPrice(partnerId);
    }
}
