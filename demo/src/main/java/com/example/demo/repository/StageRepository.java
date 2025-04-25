package com.example.demo.repository;

import com.example.demo.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    List<Stage> findByStudenteId(Long studenteId);
    List<Stage> findByPartnerAziendaleId(Long partnerId);
    @Query("SELECT s FROM Stage s WHERE s.dataInizio <= CURRENT_DATE AND s.dataFine >= CURRENT_DATE")
    List<Stage> findActiveStage();
    @Query("SELECT s FROM Stage s WHERE s.dataFine < CURRENT_DATE AND s.valutazioneFinale IS NULL")
    List<Stage> findCompletedStageWithoutValutazione();
}