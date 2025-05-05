package com.example.demo.controller;

import com.example.demo.Dto.MaterialeDidatticoDTO;
import com.example.demo.Mapper.MaterialeDidatticoMapper;
import com.example.demo.model.Corso;
import com.example.demo.model.MaterialeDidattico;
import com.example.demo.service.CorsoService;
import com.example.demo.service.MaterialeDidatticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/materiali")
public class MaterialeDidatticoController {

    @Autowired
    private MaterialeDidatticoService materialeService;

    @Autowired
    private CorsoService corsoService;

    @GetMapping
    public List<MaterialeDidatticoDTO> getAll() {
        return materialeService.getAllMateriali().stream()
                .map(MaterialeDidatticoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MaterialeDidatticoDTO getById(@PathVariable Long id) {
        MaterialeDidattico materiale = materialeService.getMaterialeById(id);
        return MaterialeDidatticoMapper.toDTO(materiale);
    }

    @PostMapping
    public MaterialeDidatticoDTO create(@RequestBody MaterialeDidatticoDTO dto) {
        Corso corso = corsoService.getCorsoById(dto.getIdCorso());
        MaterialeDidattico materiale = MaterialeDidatticoMapper.toEntity(dto, corso);
        return MaterialeDidatticoMapper.toDTO(materialeService.createMateriale(materiale));
    }

    @PutMapping("/{id}")
    public MaterialeDidatticoDTO update(@PathVariable Long id, @RequestBody MaterialeDidatticoDTO dto) {
        Corso corso = corsoService.getCorsoById(dto.getIdCorso());
        MaterialeDidattico materiale = MaterialeDidatticoMapper.toEntity(dto, corso);
        return MaterialeDidatticoMapper.toDTO(materialeService.updateMateriale(id, materiale));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materialeService.deleteMateriale(id);
    }

    @GetMapping("/titolo")
    public List<MaterialeDidatticoDTO> getByTitolo(@RequestParam String titolo) {
        return materialeService.getByTitolo(titolo).stream()
                .map(MaterialeDidatticoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/tipo")
    public List<MaterialeDidatticoDTO> getByTipo(@RequestParam String tipo) {
        return materialeService.getByTipo(tipo).stream()
                .map(MaterialeDidatticoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/corso/{idCorso}")
    public List<MaterialeDidatticoDTO> getByCorso(@PathVariable Long idCorso) {
        Corso corso = corsoService.getCorsoById(idCorso);
        return materialeService.getByCorso(corso).stream()
                .map(MaterialeDidatticoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
