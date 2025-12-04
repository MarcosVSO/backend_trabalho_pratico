package com.br.garcom_eletronico.modules.categoria.controller;

import com.br.garcom_eletronico.modules.categoria.dto.CategoriaDTO;
import com.br.garcom_eletronico.modules.categoria.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @GetMapping
    public List<CategoriaDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO create(@RequestBody CategoriaDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}