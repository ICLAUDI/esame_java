package com.example.demo.repository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
     List<Corso> findByCategoria(Categoria categoria);
    List<Corso> findByDataInizioAfterAndDataFineBefore(LocalDate dataInizio, LocalDate dataFine);
    List<Corso> findTop5ByOrderByDataInizioDesc();
    @Query("SELECT c FROM Corso c JOIN c.iscrizioni i GROUP BY c HAVING COUNT(i) > :numeroMinimo")
    List<Corso> findCorsiWithMoreThanXIscrizioni(int numeroMinimo);
    
}