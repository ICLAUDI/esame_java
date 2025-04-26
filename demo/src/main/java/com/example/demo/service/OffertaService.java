package com.example.demo.service;

import com.example.demo.model.Offerta;

import java.time.LocalDate;
import java.util.List;

public interface OffertaService {
    List<Offerta> getAllOfferte();
    Offerta getOffertaById(Long id);
    Offerta createOfferta(Offerta offerta);
    Offerta updateOfferta(Long id, Offerta offerta);
    void deleteOfferta(Long id);

    List<Offerta> getOfferteAttive(LocalDate data);
    List<Offerta> getOfferteByTipo(String tipoOfferta);
    List<Offerta> getOfferteConScontoMaggioreDel50();
    List<Offerta> getOfferteAttivePerPartner(Long partnerId);
}
