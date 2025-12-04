package com.br.garcom_eletronico.modules.categoria.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.categoria.Categoria;
import com.br.garcom_eletronico.modules.categoria.dto.CategoriaDTO;
import com.br.garcom_eletronico.modules.categoria.mapper.CategoriaMapper;
import com.br.garcom_eletronico.modules.categoria.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public List<CategoriaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public CategoriaDTO findById(Long id) {
        return repository.findById(id)
                .map((categoria) -> mapper.toDto(getEntity(id)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
    }

    public CategoriaDTO create(CategoriaDTO dto) {
        Categoria entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public CategoriaDTO update(Long id, CategoriaDTO dto) {
        Categoria entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        Categoria entity = getEntity(id);
        repository.delete(entity);
    }

    private Categoria getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id " + id));
    }
}