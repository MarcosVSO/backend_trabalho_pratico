package com.br.garcom_eletronico.modules.cliente.mapper;

import com.br.garcom_eletronico.modules.cliente.Cliente;
import com.br.garcom_eletronico.modules.cliente.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO toDto(Cliente entity) {
        if (entity == null) {
            return null;
        }
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setHoraChegada(entity.getHoraChegada());
        dto.setHoraSaida(entity.getHoraSaida());
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setHoraChegada(dto.getHoraChegada());
        entity.setHoraSaida(dto.getHoraSaida());
        return entity;
    }

    public void updateEntityFromDto(ClienteDTO dto, Cliente entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setHoraChegada(dto.getHoraChegada());
        entity.setHoraSaida(dto.getHoraSaida());
    }
}