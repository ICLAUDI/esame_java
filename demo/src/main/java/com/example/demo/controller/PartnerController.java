package com.example.demo.controller;

import com.example.demo.model.Partner;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    // Crea un nuovo partner
    @PostMapping
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
        Partner createdPartner = partnerService.createPartner(partner);
        return ResponseEntity.ok(createdPartner);
    }

    // Ottieni tutti i partner
    @GetMapping
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    // Ottieni partner per ID
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable Long id) {
        Optional<Partner> partner = partnerService.getPartnerById(id);
        return partner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cerca partner per nome azienda
    @GetMapping("/searchByName")
    public List<Partner> getPartnerByNomeAzienda(@RequestParam String nomeAzienda) {
        return partnerService.getPartnerByNomeAzienda(nomeAzienda);
    }

    // Cerca partner per settore
    @GetMapping("/searchBySector")
    public List<Partner> getPartnerBySettore(@RequestParam String settore) {
        return partnerService.getPartnerBySettore(settore);
    }

    // Cerca partner per referente
    @GetMapping("/searchByReferente")
    public List<Partner> getPartnerByReferente(@RequestParam String referente) {
        return partnerService.getPartnerByReferente(referente);
    }

    // Aggiorna i dati di un partner esistente
    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Long id, @RequestBody Partner partner) {
        Partner updatedPartner = partnerService.updatePartner(id, partner);
        return updatedPartner != null ? ResponseEntity.ok(updatedPartner) : ResponseEntity.notFound().build();
    }

    // Elimina un partner
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }
}
