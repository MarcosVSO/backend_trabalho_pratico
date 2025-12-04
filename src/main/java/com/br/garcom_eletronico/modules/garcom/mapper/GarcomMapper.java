package com.br.garcom_eletronico.modules.garcom.mapper;

import com.br.garcom_eletronico.modules.garcom.Garcom;
import com.br.garcom_eletronico.modules.garcom.dto.GarcomDTO;
import org.springframework.stereotype.Component;

@Component
public class GarcomMapper {

    public GarcomDTO toDto(Garcom entity) {
        if (entity == null) {
            return null;
        }
        GarcomDTO dto = new GarcomDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

    public Garcom toEntity(GarcomDTO dto) {
        if (dto == null) {
            return null;
        }
        Garcom entity = new Garcom();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }

    public void updateEntityFromDto(GarcomDTO dto, Garcom entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
    }
}