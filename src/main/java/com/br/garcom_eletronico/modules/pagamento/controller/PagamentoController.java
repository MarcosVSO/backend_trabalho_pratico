package com.br.garcom_eletronico.modules.pagamento.controller;

import com.br.garcom_eletronico.modules.pagamento.dto.PagamentoDTO;
import com.br.garcom_eletronico.modules.pagamento.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public List<PagamentoDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PagamentoDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDTO create(@RequestBody PagamentoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PagamentoDTO update(@PathVariable Long id, @RequestBody PagamentoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}