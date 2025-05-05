package com.example.demo.controller;

import com.example.demo.Dto.PartnerDTO;
import com.example.demo.Mapper.PartnerMapper;
import com.example.demo.model.Partner;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    // Crea un nuovo partner
    @PostMapping
    public ResponseEntity<PartnerDTO> createPartner(@RequestBody PartnerDTO partnerDTO) {
        Partner partner = PartnerMapper.toEntity(partnerDTO);
        Partner created = partnerService.createPartner(partner);
        return ResponseEntity.ok(PartnerMapper.toDTO(created));
    }

    // Ottieni tutti i partner
    @GetMapping
    public List<PartnerDTO> getAllPartners() {
        return partnerService.getAllPartners()
                .stream()
                .map(PartnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Ottieni partner per ID
    @GetMapping("/{id}")
    public ResponseEntity<PartnerDTO> getPartnerById(@PathVariable Long id) {
        Optional<Partner> partner = partnerService.getPartnerById(id);
        return partner.map(value -> ResponseEntity.ok(PartnerMapper.toDTO(value)))
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cerca partner per nome azienda
    @GetMapping("/searchByName")
    public List<PartnerDTO> getPartnerByNomeAzienda(@RequestParam String nomeAzienda) {
        return partnerService.getPartnerByNomeAzienda(nomeAzienda)
                .stream()
                .map(PartnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Cerca partner per settore
    @GetMapping("/searchBySector")
    public List<PartnerDTO> getPartnerBySettore(@RequestParam String settore) {
        return partnerService.getPartnerBySettore(settore)
                .stream()
                .map(PartnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Cerca partner per referente
    @GetMapping("/searchByReferente")
    public List<PartnerDTO> getPartnerByReferente(@RequestParam String referente) {
        return partnerService.getPartnerByReferente(referente)
                .stream()
                .map(PartnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Aggiorna i dati di un partner esistente
    @PutMapping("/{id}")
    public ResponseEntity<PartnerDTO> updatePartner(@PathVariable Long id, @RequestBody PartnerDTO partnerDTO) {
        Partner updated = partnerService.updatePartner(id, PartnerMapper.toEntity(partnerDTO));
        return updated != null ? ResponseEntity.ok(PartnerMapper.toDTO(updated)) : ResponseEntity.notFound().build();
    }

    // Elimina un partner
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }
}
