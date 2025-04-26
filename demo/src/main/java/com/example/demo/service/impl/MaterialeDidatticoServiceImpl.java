package com.example.demo.service.impl;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.model.Corso;
import com.example.demo.repository.MaterialeDidatticoRepository;
import com.example.demo.service.MaterialeDidatticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialeDidatticoServiceImpl implements MaterialeDidatticoService {

    @Autowired
    private MaterialeDidatticoRepository repository;

    @Override
    public List<MaterialeDidattico> getAllMateriali() {
        return repository.findAll();
    }

    @Override
    public MaterialeDidattico getMaterialeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MaterialeDidattico createMateriale(MaterialeDidattico materiale) {
        return repository.save(materiale);
    }

    @Override
    public MaterialeDidattico updateMateriale(Long id, MaterialeDidattico materiale) {
        materiale.setIdMateriale(id);
        return repository.save(materiale);
    }

    @Override
    public void deleteMateriale(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MaterialeDidattico> getByCorso(Corso corso) {
        return repository.findByCorso(corso);
    }

    @Override
    public List<MaterialeDidattico> getByTitolo(String titolo) {
        return repository.findByTitoloContainingIgnoreCase(titolo);
    }

    @Override
    public List<MaterialeDidattico> getByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }
}
