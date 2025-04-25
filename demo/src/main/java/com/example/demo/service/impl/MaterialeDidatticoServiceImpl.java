package com.example.demo.service.impl;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.repository.MaterialeDidatticoRepository;
import com.example.demo.service.MaterialeDidatticoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MaterialeDidatticoServiceImpl implements MaterialeDidatticoService {

    private final MaterialeDidatticoRepository materialeDidatticoRepository;

    public MaterialeDidatticoServiceImpl(MaterialeDidatticoRepository materialeDidatticoRepository) {
        this.materialeDidatticoRepository = materialeDidatticoRepository;
    }

    @Override
    public MaterialeDidattico saveMaterialeDidattico(MaterialeDidattico materialeDidattico) {
        return materialeDidatticoRepository.save(materialeDidattico);
    }

    @Override
    public MaterialeDidattico getMaterialeDidatticoById(Long id) {
        return materialeDidatticoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materiale didattico non trovato con id: " + id));
    }

    @Override
    public List<MaterialeDidattico> getMaterialiByLezioneId(Long lezioneId) {
        return materialeDidatticoRepository.findByLezioneId(lezioneId);
    }

    @Override
    public List<MaterialeDidattico> getMaterialiByTipo(String tipoMateriale) {
        return materialeDidatticoRepository.findByTipoMateriale(tipoMateriale);
    }

    @Override
    public List<MaterialeDidattico> getAllMaterialiByCorsoId(Long corsoId) {
        return materialeDidatticoRepository.findAllMaterialiByCorsoId(corsoId);
    }

    @Override
    public List<MaterialeDidattico> getRecentMateriali(LocalDate data) {
        return materialeDidatticoRepository.findRecentMateriali(data);
    }

    @Override
    public void deleteMaterialeDidattico(Long id) {
        if (!materialeDidatticoRepository.existsById(id)) {
            throw new RuntimeException("Materiale didattico non trovato con id: " + id);
        }
        materialeDidatticoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return materialeDidatticoRepository.existsById(id);
    }
}
