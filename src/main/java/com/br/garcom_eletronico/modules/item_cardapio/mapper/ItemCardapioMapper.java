package com.br.garcom_eletronico.modules.item_cardapio.mapper;

import com.br.garcom_eletronico.modules.item_cardapio.ItemCardapio;
import com.br.garcom_eletronico.modules.item_cardapio.dto.ItemCardapioDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemCardapioMapper {

    public ItemCardapioDTO toDto(ItemCardapio entity) {
        if (entity == null) {
            return null;
        }
        ItemCardapioDTO dto = new ItemCardapioDTO();
        dto.setId(entity.getId());
        dto.setIngredientes(entity.getIngredientes());
        dto.setPreco(entity.getPreco());
        dto.setDisponivelNaCozinha(entity.getDisponivelNaCozinha());
        if (entity.getCategoria() != null) {
            dto.setCategoriaId(entity.getCategoria().getId());
            dto.setCategoriaNome(entity.getCategoria().getNome());
        }
        return dto;
    }

    public ItemCardapio toEntity(ItemCardapioDTO dto) {
        if (dto == null) {
            return null;
        }
        ItemCardapio entity = new ItemCardapio();
        entity.setId(dto.getId());
        entity.setIngredientes(dto.getIngredientes());
        entity.setPreco(dto.getPreco());
        entity.setDisponivelNaCozinha(dto.getDisponivelNaCozinha());
        return entity;
    }

    public void updateEntityFromDto(ItemCardapioDTO dto, ItemCardapio entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setIngredientes(dto.getIngredientes());
        entity.setPreco(dto.getPreco());
        entity.setDisponivelNaCozinha(dto.getDisponivelNaCozinha());
    }
}


