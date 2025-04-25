package com.example.demo.service.impl;

import com.example.demo.model.Categoria;
import com.example.demo.model.Corso;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.service.CorsoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CorsoServiceImpl implements CorsoService {

    private final CorsoRepository corsoRepository;

    public CorsoServiceImpl(CorsoRepository corsoRepository) {
        this.corsoRepository = corsoRepository;
    }

    @Override
    public Corso saveCorso(Corso corso) {
        return corsoRepository.save(corso);
    }

    @Override
    public Corso getCorsoById(Long id) {
        return corsoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corso non trovato con id: " + id));
    }

    @Override
    public List<Corso> getAllCorsi() {
        return corsoRepository.findAll();
    }

    @Override
    public List<Corso> getCorsiByCategoria(Categoria categoria) {
        return corsoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Corso> getCorsiByPeriodo(LocalDate dataInizio, LocalDate dataFine) {
        return corsoRepository.findByDataInizioAfterAndDataFineBefore(dataInizio, dataFine);
    }

    @Override
    public List<Corso> getCorsiRecenti() {
        return corsoRepository.findTop5ByOrderByDataInizioDesc();
    }

    @Override
    public List<Corso> getCorsiWithMoreThanXIscrizioni(int numeroMinimo) {
        return corsoRepository.findCorsiWithMoreThanXIscrizioni(numeroMinimo);
    }

    @Override
    public void deleteCorso(Long id) {
        if (!corsoRepository.existsById(id)) {
            throw new RuntimeException("Impossibile eliminare, corso non trovato con id: " + id);
        }
        corsoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return corsoRepository.existsById(id);
    }
}