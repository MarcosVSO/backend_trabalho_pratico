package com.br.garcom_eletronico.modules.mesa.mapper;

import com.br.garcom_eletronico.modules.mesa.Mesa;
import com.br.garcom_eletronico.modules.mesa.dto.MesaDTO;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDTO toDto(Mesa entity) {
        if (entity == null) {
            return null;
        }
        MesaDTO dto = new MesaDTO();
        dto.setNumero(entity.getNumero());
        dto.setDisponivel(entity.isDisponivel());
        return dto;
    }

    public Mesa toEntity(MesaDTO dto) {
        if (dto == null) {
            return null;
        }
        Mesa entity = new Mesa();
        entity.setNumero(dto.getNumero());
        entity.setDisponivel(Boolean.TRUE.equals(dto.getDisponivel()));
        return entity;
    }

    public void updateEntityFromDto(MesaDTO dto, Mesa entity) {
        if (dto == null || entity == null) {
            return;
        }
        if (dto.getDisponivel() != null) {
            entity.setDisponivel(dto.getDisponivel());
        }
    }
}