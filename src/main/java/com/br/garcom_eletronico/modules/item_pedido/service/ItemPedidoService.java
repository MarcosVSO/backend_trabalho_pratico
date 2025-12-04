package com.br.garcom_eletronico.modules.item_pedido.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.item_cardapio.ItemCardapio;
import com.br.garcom_eletronico.modules.item_cardapio.repository.ItemCardapioRepository;
import com.br.garcom_eletronico.modules.item_pedido.ItemPedido;
import com.br.garcom_eletronico.modules.item_pedido.dto.ItemPedidoDTO;
import com.br.garcom_eletronico.modules.item_pedido.mapper.ItemPedidoMapper;
import com.br.garcom_eletronico.modules.item_pedido.repository.ItemPedidoRepository;
import com.br.garcom_eletronico.modules.pedido.Pedido;
import com.br.garcom_eletronico.modules.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final ItemPedidoMapper mapper;
    private final ItemCardapioRepository itemCardapioRepository;
    private final PedidoRepository pedidoRepository;

    public List<ItemPedidoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ItemPedidoDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public ItemPedidoDTO create(ItemPedidoDTO dto) {
        ItemPedido entity = mapper.toEntity(dto);
        entity.setId(null);
        entity.setItemCardapio(resolveItemCardapio(dto.getItemCardapioId()));
        entity.setPedido(resolvePedido(dto.getPedidoId()));
        return mapper.toDto(repository.save(entity));
    }

    public ItemPedidoDTO update(Long id, ItemPedidoDTO dto) {
        ItemPedido entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        entity.setItemCardapio(resolveItemCardapio(dto.getItemCardapioId()));
        entity.setPedido(resolvePedido(dto.getPedidoId()));
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        ItemPedido entity = getEntity(id);
        repository.delete(entity);
    }

    private ItemPedido getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemPedido não encontrado com id " + id));
    }

    private ItemCardapio resolveItemCardapio(Long id) {
        if (id == null) {
            return null;
        }
        return itemCardapioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ItemCardapio não encontrado com id " + id));
    }

    private Pedido resolvePedido(Long id) {
        if (id == null) {
            return null;
        }
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com id " + id));
    }
}