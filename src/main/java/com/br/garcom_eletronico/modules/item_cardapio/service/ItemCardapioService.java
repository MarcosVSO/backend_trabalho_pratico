package com.br.garcom_eletronico.modules.item_cardapio.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.item_cardapio.ItemCardapio;
import com.br.garcom_eletronico.modules.item_cardapio.dto.ItemCardapioDTO;
import com.br.garcom_eletronico.modules.item_cardapio.mapper.ItemCardapioMapper;
import com.br.garcom_eletronico.modules.item_cardapio.repository.ItemCardapioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemCardapioService {

    private final ItemCardapioRepository repository;
    private final ItemCardapioMapper mapper;

    public List<ItemCardapioDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ItemCardapioDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public ItemCardapioDTO create(ItemCardapioDTO dto) {
        ItemCardapio entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public ItemCardapioDTO update(Long id, ItemCardapioDTO dto) {
        ItemCardapio entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        ItemCardapio entity = getEntity(id);
        repository.delete(entity);
    }

    private ItemCardapio getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemCardapio not found with id " + id));
    }
}

