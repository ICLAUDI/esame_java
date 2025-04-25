package com.example.demo.service;

import com.example.demo.model.MaterialeDidattico;

import java.time.LocalDate;
import java.util.List;

public interface MaterialeDidatticoService {
    MaterialeDidattico saveMaterialeDidattico(MaterialeDidattico materialeDidattico);
    MaterialeDidattico getMaterialeDidatticoById(Long id);
    List<MaterialeDidattico> getMaterialiByLezioneId(Long lezioneId);
    List<MaterialeDidattico> getMaterialiByTipo(String tipoMateriale);
    List<MaterialeDidattico> getAllMaterialiByCorsoId(Long corsoId);
    List<MaterialeDidattico> getRecentMateriali(LocalDate data);
    void deleteMaterialeDidattico(Long id);
    boolean existsById(Long id);
}
