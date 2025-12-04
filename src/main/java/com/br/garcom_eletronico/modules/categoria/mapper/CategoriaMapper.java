package com.br.garcom_eletronico.modules.categoria.mapper;

import com.br.garcom_eletronico.modules.categoria.Categoria;
import com.br.garcom_eletronico.modules.categoria.dto.CategoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaDTO toDto(Categoria entity) {
        if (entity == null) {
            return null;
        }
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

    public Categoria toEntity(CategoriaDTO dto) {
        if (dto == null) {
            return null;
        }
        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }

    public void updateEntityFromDto(CategoriaDTO dto, Categoria entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
    }
}