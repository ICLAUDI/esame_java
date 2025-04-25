package com.example.demo.service;

import com.example.demo.model.Offerta;

import java.time.LocalDate;
import java.util.List;

public interface OffertaService {
    Offerta saveOfferta(Offerta offerta);
    Offerta getOffertaById(Long id);
    List<Offerta> getOfferteByTipo(String tipoOfferta);
    List<Offerta> getOfferteWithMoreThan50PercentDiscount();
    List<Offerta> getActiveOfferteByCorsoId(Long corsoId);
    List<Offerta> getOfferteByScadenzaAfter(LocalDate today);
    void deleteOfferta(Long id);
    boolean existsById(Long id);
}
