package com.example.demo.repository;

import com.example.demo.model.Valutazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ValutazioneRepository extends JpaRepository<Valutazione, Long> {

    List<Valutazione> findByStudenteId(Long studenteId);
    List<Valutazione> findByCorsoIdOrderByDataValutazioneDesc(Long corsoId);
    @Query("SELECT AVG(v.voto) FROM Valutazione v WHERE v.corso.id = :corsoId")
    Double calculateAverageVotoByCorsoId(Long corsoId);
    @Query("SELECT v FROM Valutazione v WHERE v.voto >= :votoMinimo")
    List<Valutazione> findValutazioniWithHighVoto(Double votoMinimo);
}