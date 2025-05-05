package com.example.demo.controller;

import com.example.demo.Dto.OffertaDTO;
import com.example.demo.Mapper.OffertaMapper;
import com.example.demo.model.Offerta;
import com.example.demo.service.OffertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/offerte")
public class OffertaController {

    @Autowired
    private OffertaService service;

    @GetMapping
    public List<OffertaDTO> getAll() {
        return service.getAllOfferte().stream()
                .map(OffertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OffertaDTO getById(@PathVariable Long id) {
        Offerta offerta = service.getOffertaById(id);
        return OffertaMapper.toDTO(offerta);
    }

    @PostMapping
    public OffertaDTO create(@RequestBody OffertaDTO dto) {
        Offerta entity = OffertaMapper.toEntity(dto);
        entity = service.createOfferta(entity);
        return OffertaMapper.toDTO(entity);
    }

    @PutMapping("/{id}")
    public OffertaDTO update(@PathVariable Long id, @RequestBody OffertaDTO dto) {
        Offerta entity = OffertaMapper.toEntity(dto);
        entity.setId_offerta(id);
        entity = service.updateOfferta(id, entity);
        return OffertaMapper.toDTO(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOfferta(id);
    }

    @GetMapping("/attive")
    public List<OffertaDTO> getAttive(@RequestParam(name = "data") String data) {
        return service.getOfferteAttive(LocalDate.parse(data)).stream()
                .map(OffertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/tipo")
    public List<OffertaDTO> getByTipo(@RequestParam String tipo) {
        return service.getOfferteByTipo(tipo).stream()
                .map(OffertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/super-sconto")
    public List<OffertaDTO> getOfferteScontate() {
        return service.getOfferteConScontoMaggioreDel50().stream()
                .map(OffertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/partner/{partnerId}")
    public List<OffertaDTO> getByPartner(@PathVariable Long partnerId) {
        return service.getOfferteAttivePerPartner(partnerId).stream()
                .map(OffertaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
