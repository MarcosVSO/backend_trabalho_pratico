package com.br.garcom_eletronico.modules.pedido.controller;

import com.br.garcom_eletronico.modules.pedido.dto.PedidoDTO;
import com.br.garcom_eletronico.modules.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    public List<PedidoDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO create(@RequestBody PedidoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PedidoDTO update(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/mesa/{id}")
    public List<PedidoDTO> findPedidosByMesa(@PathVariable Integer id) {
        return service.findPedidosByMesa(id);
    }

    @GetMapping("/status/pendente")
    public List<PedidoDTO> findPedidosPendentes() {
        return service.findPedidosPendentes();
    }

    @GetMapping("/tempo-medio-entrega")
    public Double getTempoMedioEntrega() {
        return service.getTempoMedioEntrega();
    }
}


