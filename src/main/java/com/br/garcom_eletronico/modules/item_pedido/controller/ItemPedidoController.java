package com.br.garcom_eletronico.modules.item_pedido.controller;

import com.br.garcom_eletronico.modules.item_pedido.dto.ItemPedidoDTO;
import com.br.garcom_eletronico.modules.item_pedido.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService service;

    @GetMapping
    public List<ItemPedidoDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemPedidoDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedidoDTO create(@RequestBody ItemPedidoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ItemPedidoDTO update(@PathVariable Long id, @RequestBody ItemPedidoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}