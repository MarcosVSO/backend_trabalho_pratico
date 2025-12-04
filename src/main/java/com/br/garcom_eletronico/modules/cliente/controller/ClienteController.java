package com.br.garcom_eletronico.modules.cliente.controller;

import com.br.garcom_eletronico.modules.cliente.dto.ClienteDTO;
import com.br.garcom_eletronico.modules.cliente.service.ClienteService;
import com.br.garcom_eletronico.modules.pedido.dto.PedidoDTO;
import com.br.garcom_eletronico.modules.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final PedidoService pedidoService;

    @GetMapping
    public List<ClienteDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody ClienteDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{idCliente}/ultimo-pedido")
    public PedidoDTO findUltimoPedido(@PathVariable Long idCliente) {
        return pedidoService.findUltimoPedidoByCliente(idCliente);
    }

    @GetMapping("/sortear")
    public ClienteDTO sortearCliente() {
        return service.sortearCliente();
    }

    @GetMapping("/cliente-aniversariante")
    public List<ClienteDTO> findAniversariantes() {
        return service.findAniversariantes();
    }
}

