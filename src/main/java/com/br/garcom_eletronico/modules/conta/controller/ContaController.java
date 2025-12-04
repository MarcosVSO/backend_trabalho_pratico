package com.br.garcom_eletronico.modules.conta.controller;

import com.br.garcom_eletronico.modules.conta.dto.ContaDTO;
import com.br.garcom_eletronico.modules.conta.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @GetMapping
    public List<ContaDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ContaDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaDTO create(@RequestBody ContaDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ContaDTO update(@PathVariable Integer id, @RequestBody ContaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}