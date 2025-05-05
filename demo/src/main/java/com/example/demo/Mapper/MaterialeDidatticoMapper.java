package com.example.demo.Mapper;

import com.example.demo.Dto.MaterialeDidatticoDTO;
import com.example.demo.model.Corso;
import com.example.demo.model.MaterialeDidattico;

public class MaterialeDidatticoMapper {

    public static MaterialeDidatticoDTO toDTO(MaterialeDidattico materiale) {
        if (materiale == null) return null;

        return new MaterialeDidatticoDTO(
                materiale.getIdMateriale(),
                materiale.getCorso().getIdCorso(),
                materiale.getTitolo(),
                materiale.getDescrizione(),
                materiale.getFile(),
                materiale.getTipo()
        );
    }

    public static MaterialeDidattico toEntity(MaterialeDidatticoDTO dto, Corso corso) {
        if (dto == null) return null;

        MaterialeDidattico materiale = new MaterialeDidattico();
        materiale.setIdMateriale(dto.getIdMateriale());
        materiale.setCorso(corso);
        materiale.setTitolo(dto.getTitolo());
        materiale.setDescrizione(dto.getDescrizione());
        materiale.setFile(dto.getFile());
        materiale.setTipo(dto.getTipo());
        return materiale;
    }
}
