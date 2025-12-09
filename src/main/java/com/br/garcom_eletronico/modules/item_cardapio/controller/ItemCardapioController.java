package com.br.garcom_eletronico.modules.item_cardapio.controller;

import com.br.garcom_eletronico.modules.item_cardapio.dto.ItemCardapioDTO;
import com.br.garcom_eletronico.modules.item_cardapio.service.ItemCardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-cardapio")
@RequiredArgsConstructor
public class ItemCardapioController {

    private final ItemCardapioService service;

    @GetMapping
    public List<ItemCardapioDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemCardapioDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemCardapioDTO create(@RequestBody ItemCardapioDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ItemCardapioDTO update(@PathVariable Long id, @RequestBody ItemCardapioDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/por-categoria/{categoria}")
    public List<ItemCardapioDTO> findByCategoria(@PathVariable String categoria) {
        return service.findByCategoria(categoria);
    }

    @GetMapping("/mais-pedido")
    public ItemCardapioDTO findItemMaisPedido() {
        return service.findItemMaisPedido();
    }

    @GetMapping("/cozinha-pedidos-pendentes")
    public List<ItemCardapioDTO> findByDisponivelNaCozinha(@RequestParam Boolean disponivel) {
        return service.findByDisponivelNaCozinha(disponivel);
    }
}


