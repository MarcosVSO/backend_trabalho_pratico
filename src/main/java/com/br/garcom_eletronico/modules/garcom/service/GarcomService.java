package com.br.garcom_eletronico.modules.garcom.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.garcom.Garcom;
import com.br.garcom_eletronico.modules.garcom.dto.GarcomDTO;
import com.br.garcom_eletronico.modules.garcom.mapper.GarcomMapper;
import com.br.garcom_eletronico.modules.garcom.repository.GarcomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GarcomService {

    private final GarcomRepository repository;
    private final GarcomMapper mapper;

    public List<GarcomDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public GarcomDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public GarcomDTO create(GarcomDTO dto) {
        Garcom entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public GarcomDTO update(Long id, GarcomDTO dto) {
        Garcom entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        Garcom entity = getEntity(id);
        repository.delete(entity);
    }

    private Garcom getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Garcom não encontrado com id " + id));
    }
}