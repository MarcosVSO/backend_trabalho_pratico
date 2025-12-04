package com.br.garcom_eletronico.modules.mesa.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.mesa.Mesa;
import com.br.garcom_eletronico.modules.mesa.dto.MesaDTO;
import com.br.garcom_eletronico.modules.mesa.mapper.MesaMapper;
import com.br.garcom_eletronico.modules.mesa.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaRepository repository;
    private final MesaMapper mapper;

    public List<MesaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public MesaDTO findById(Integer id) {
        return mapper.toDto(getEntity(id));
    }

    public MesaDTO create(MesaDTO dto) {
        Mesa entity = mapper.toEntity(dto);
        entity.setNumero(null);
        return mapper.toDto(repository.save(entity));
    }

    public MesaDTO update(Integer id, MesaDTO dto) {
        Mesa entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        Mesa entity = getEntity(id);
        repository.delete(entity);
    }

    private Mesa getEntity(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mesa não encontrada com id " + id));
    }
}