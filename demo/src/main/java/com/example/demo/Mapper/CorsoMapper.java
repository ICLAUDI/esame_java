package com.example.demo.Mapper;

import com.example.demo.model.Corso;
import com.example.demo.Dto.CorsoDTO;

public class CorsoMapper {

    public static CorsoDTO toDTO(Corso corso) {
        CorsoDTO corsoDTO = new CorsoDTO();
        corsoDTO.setIdCorso(corso.getIdCorso());
        corsoDTO.setTitolo(corso.getTitolo());
        corsoDTO.setDescrizione(corso.getDescrizione());
        corsoDTO.setDurata(corso.getDurata());
        corsoDTO.setCategoriaId(corso.getCategoria().getIdCategoria());  // Mappa solo l'id della categoria
        corsoDTO.setDocenteId(corso.getDocente().getIdDocente());        // Mappa solo l'id del docente
        corsoDTO.setDataInizio(corso.getDataInizio());
        corsoDTO.setDataFine(corso.getDataFine());
        corsoDTO.setPostiDisponibili(corso.getPostiDisponibili());
        return corsoDTO;
    }

    public static Corso toEntity(CorsoDTO corsoDTO) {
        Corso corso = new Corso();
        corso.setIdCorso(corsoDTO.getIdCorso());
        corso.setTitolo(corsoDTO.getTitolo());
        corso.setDescrizione(corsoDTO.getDescrizione());
        corso.setDurata(corsoDTO.getDurata());
        corso.setDataInizio(corsoDTO.getDataInizio());
        corso.setDataFine(corsoDTO.getDataFine());
        corso.setPostiDisponibili(corsoDTO.getPostiDisponibili());
        return corso;
    }
}
