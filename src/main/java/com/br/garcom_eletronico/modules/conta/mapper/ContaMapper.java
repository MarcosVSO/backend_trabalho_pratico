package com.br.garcom_eletronico.modules.conta.mapper;

import com.br.garcom_eletronico.modules.conta.Conta;
import com.br.garcom_eletronico.modules.conta.dto.ContaDTO;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {

    public ContaDTO toDto(Conta entity) {
        if (entity == null) {
            return null;
        }
        ContaDTO dto = new ContaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        if (entity.getPagamento() != null) {
            dto.setPagamentoId(entity.getPagamento().getId());
        }
        return dto;
    }

    public Conta toEntity(ContaDTO dto) {
        if (dto == null) {
            return null;
        }
        Conta entity = new Conta();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }

    public void updateEntityFromDto(ContaDTO dto, Conta entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
    }
}