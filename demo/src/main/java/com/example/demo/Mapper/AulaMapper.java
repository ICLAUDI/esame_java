package com.example.demo.Mapper;

import com.example.demo.Dto.AulaDTO;
import com.example.demo.model.Aula;

public class AulaMapper {

    // Convertire Aula in AulaDTO
    public static AulaDTO toDTO(Aula aula) {
        return new AulaDTO(
            aula.getIdAula(),
            aula.getNome(),
            aula.getCapacita(),
            aula.getEdificio(),
            aula.getAttrezzature(),
            aula.getAccessibile()
        );
    }

    // Convertire AulaDTO in Aula
    public static Aula toEntity(AulaDTO aulaDTO) {
        Aula aula = new Aula();
        aula.setIdAula(aulaDTO.getIdAula());
        aula.setNome(aulaDTO.getNome());
        aula.setCapacita(aulaDTO.getCapacita());
        aula.setEdificio(aulaDTO.getEdificio());
        aula.setAttrezzature(aulaDTO.getAttrezzature());
        aula.setAccessibile(aulaDTO.getAccessibile());
        return aula;
    }
}
