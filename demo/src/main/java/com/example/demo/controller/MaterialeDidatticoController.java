package com.example.demo.controller;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.service.MaterialeDidatticoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/materiali")
public class MaterialeDidatticoController {

    private final MaterialeDidatticoService materialeDidatticoService;

    public MaterialeDidatticoController(MaterialeDidatticoService materialeDidatticoService) {
        this.materialeDidatticoService = materialeDidatticoService;
    }

    @PostMapping
    public MaterialeDidattico createMateriale(@RequestBody MaterialeDidattico materialeDidattico) {
        return materialeDidatticoService.saveMaterialeDidattico(materialeDidattico);
    }

    @GetMapping("/{id}")
    public MaterialeDidattico getMaterialeById(@PathVariable Long id) {
        return materialeDidatticoService.getMaterialeDidatticoById(id);
    }

    @GetMapping("/lezione/{lezioneId}")
    public List<MaterialeDidattico> getMaterialiByLezione(@PathVariable Long lezioneId) {
        return materialeDidatticoService.getMaterialiByLezioneId(lezioneId);
    }

    @GetMapping("/tipo/{tipoMateriale}")
    public List<MaterialeDidattico> getMaterialiByTipo(@PathVariable String tipoMateriale) {
        return materialeDidatticoService.getMaterialiByTipo(tipoMateriale);
    }

    @GetMapping("/corso/{corsoId}")
    public List<MaterialeDidattico> getAllMaterialiByCorso(@PathVariable Long corsoId) {
        return materialeDidatticoService.getAllMaterialiByCorsoId(corsoId);
    }

    @GetMapping("/recenti")
    public List<MaterialeDidattico> getRecentMateriali(@RequestParam LocalDate data) {
        return materialeDidatticoService.getRecentMateriali(data);
    }

    @DeleteMapping("/{id}")
    public void deleteMateriale(@PathVariable Long id) {
        materialeDidatticoService.deleteMaterialeDidattico(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return materialeDidatticoService.existsById(id);
    }
}
