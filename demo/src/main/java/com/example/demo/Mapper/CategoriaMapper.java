package com.example.demo.Mapper;

import com.example.demo.Dto.CategoriaDTO;
import com.example.demo.model.Categoria;

public class CategoriaMapper {

    // Convertire Categoria in CategoriaDTO
    public static CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(
            categoria.getIdCategoria(),
            categoria.getNome(),
            categoria.getDescrizione(),
            categoria.getAreaTematica()
        );
    }

    // Convertire CategoriaDTO in Categoria
    public static Categoria toEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(categoriaDTO.getIdCategoria());
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescrizione(categoriaDTO.getDescrizione());
        categoria.setAreaTematica(categoriaDTO.getAreaTematica());
        return categoria;
    }
}
