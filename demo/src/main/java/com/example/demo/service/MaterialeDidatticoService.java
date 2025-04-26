package com.example.demo.service;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.model.Corso;

import java.util.List;

public interface MaterialeDidatticoService {
    List<MaterialeDidattico> getAllMateriali();
    MaterialeDidattico getMaterialeById(Long id);
    MaterialeDidattico createMateriale(MaterialeDidattico materiale);
    MaterialeDidattico updateMateriale(Long id, MaterialeDidattico materiale);
    void deleteMateriale(Long id);

    List<MaterialeDidattico> getByCorso(Corso corso);
    List<MaterialeDidattico> getByTitolo(String titolo);
    List<MaterialeDidattico> getByTipo(String tipo);
}
