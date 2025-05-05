package com.example.demo.Mapper;

import com.example.demo.Dto.OffertaDTO;
import com.example.demo.model.Offerta;
import com.example.demo.model.Partner;

public class OffertaMapper {

    public static OffertaDTO toDTO(Offerta offerta) {
        if (offerta == null) return null;

        return new OffertaDTO(
                offerta.getId_offerta(),
                offerta.getPartner() != null ? offerta.getPartner().getIdPartner() : null,
                offerta.getDescrizione(),
                offerta.getRequisiti(),
                offerta.getDataPubblicazione(),
                offerta.getDataScadenza(),
                offerta.getTipoOfferta(),
                offerta.getPrezzoOriginale(),
                offerta.getPrezzoScontato()
        );
    }

    public static Offerta toEntity(OffertaDTO dto) {
        if (dto == null) return null;

        Partner partner = new Partner();
        partner.setIdPartner(dto.getPartnerId());

        Offerta offerta = new Offerta();
        offerta.setId_offerta(dto.getId());
        offerta.setPartner(partner);
        offerta.setDescrizione(dto.getDescrizione());
        offerta.setRequisiti(dto.getRequisiti());
        offerta.setDataPubblicazione(dto.getDataPubblicazione());
        offerta.setDataScadenza(dto.getDataScadenza());
        offerta.setTipoOfferta(dto.getTipoOfferta());
        offerta.setPrezzoOriginale(dto.getPrezzoOriginale());
        offerta.setPrezzoScontato(dto.getPrezzoScontato());

        return offerta;
    }
}
