package com.br.garcom_eletronico.modules.mesa.controller;

import com.br.garcom_eletronico.modules.mesa.dto.MesaDTO;
import com.br.garcom_eletronico.modules.mesa.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@RequiredArgsConstructor
public class MesaController {

    private final MesaService service;

    @GetMapping
    public List<MesaDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MesaDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MesaDTO create(@RequestBody MesaDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public MesaDTO update(@PathVariable Integer id, @RequestBody MesaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}