package com.example.demo.repository;

import com.example.demo.model.Offerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OffertaRepository extends JpaRepository<Offerta, Long> {
    List<Offerta> findByScadenzaAfter(LocalDate today);
    List<Offerta> findByTipoOfferta(String tipoOfferta);
    @Query("SELECT o FROM Offerta o WHERE o.prezzoScontato < (o.prezzoOriginale * 0.5)")
    List<Offerta> findOfferteWithMoreThan50PercentDiscount();
    @Query("SELECT o FROM Offerta o WHERE o.corso.id = :corsoId AND o.scadenza > CURRENT_DATE ORDER BY o.prezzoScontato ASC")
    List<Offerta> findActiveOfferteByCorsoIdOrderByPrice(Long corsoId);
}