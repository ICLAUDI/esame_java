package com.example.demo.Mapper;

import com.example.demo.Dto.ValutazioneDTO;
import com.example.demo.model.Valutazione;

public class ValutazioneMapper {

    public static ValutazioneDTO toDTO(Valutazione valutazione) {
        return new ValutazioneDTO(
            valutazione.getIdValutazione(),
            valutazione.getIscrizione().getIdIscrizione(),
            valutazione.getDocente().getIdDocente(),
            valutazione.getVoto(),
            valutazione.getCommento(),
            valutazione.getDataValutazione(),
            valutazione.getTipoValutazione()
        );
    }

    public static Valutazione toEntity(ValutazioneDTO valutazioneDTO) {
        Valutazione valutazione = new Valutazione();
        // Supponiamo che i metodi per ottenere Iscrizione e Docente siano implementati
        // in modo che possiamo creare questi oggetti (da database o da id).
        // Altrimenti, potresti avere bisogno di caricarli tramite il repository
        valutazione.setIdValutazione(valutazioneDTO.getIdValutazione());
        // Qui dovresti recuperare Iscrizione e Docente in base agli id
        // e settarli su valutazione.setIscrizione(iscrizione) e valutazione.setDocente(docente).
        valutazione.setVoto(valutazioneDTO.getVoto());
        valutazione.setCommento(valutazioneDTO.getCommento());
        valutazione.setDataValutazione(valutazioneDTO.getDataValutazione());
        valutazione.setTipoValutazione(valutazioneDTO.getTipoValutazione());
        return valutazione;
    }
}
