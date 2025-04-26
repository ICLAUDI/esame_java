package com.example.demo.repository;

import com.example.demo.model.Corso;
import com.example.demo.model.Categoria;
import com.example.demo.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {

    // Trova corsi per titolo (caso insensibile)
    List<Corso> findByTitoloContainingIgnoreCase(String titolo);

    // Trova corsi per docente
    List<Corso> findByDocente(Docente docente);

    // Trova corsi per categoria
    List<Corso> findByCategoria(Categoria categoria);

    // Trova corsi che iniziano tra due date
    List<Corso> findByDataInizioBetween(Date startDate, Date endDate);

    // Trova corsi che finiscono tra due date
    List<Corso> findByDataFineBetween(Date startDate, Date endDate);

    // Trova corsi con un numero minimo di posti disponibili
    List<Corso> findByPostiDisponibiliGreaterThan(Integer postiMinimi);

    // Query personalizzata per ottenere corsi futuri (data di inizio maggiore di oggi)
    @Query("SELECT c FROM Corso c WHERE c.dataInizio > CURRENT_DATE")
    List<Corso> findFutureCorsi();

    // Query personalizzata per ottenere corsi correnti (data di inizio <= oggi e data di fine >= oggi)
    @Query("SELECT c FROM Corso c WHERE c.dataInizio <= CURRENT_DATE AND c.dataFine >= CURRENT_DATE")
    List<Corso> findCurrentCorsi();

    // Aggiungi altre query personalizzate qui, se necessario
}
