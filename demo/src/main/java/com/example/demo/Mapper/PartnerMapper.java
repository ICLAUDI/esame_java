package com.example.demo.Mapper;

import com.example.demo.Dto.PartnerDTO;
import com.example.demo.model.Partner;

public class PartnerMapper {

    public static PartnerDTO toDTO(Partner partner) {
        PartnerDTO dto = new PartnerDTO();
        dto.setId(partner.getIdPartner());
        dto.setNomeAzienda(partner.getNomeAzienda());
        dto.setSettore(partner.getSettore());
        dto.setIndirizzo(partner.getIndirizzo());
        dto.setReferente(partner.getReferente());
        dto.setTelefono(partner.getTelefono());
        return dto;
    }

    public static Partner toEntity(PartnerDTO dto) {
        Partner partner = new Partner();
        partner.setIdPartner(dto.getId());
        partner.setNomeAzienda(dto.getNomeAzienda());
        partner.setSettore(dto.getSettore());
        partner.setIndirizzo(dto.getIndirizzo());
        partner.setReferente(dto.getReferente());
        partner.setTelefono(dto.getTelefono());
        return partner;
    }
}
