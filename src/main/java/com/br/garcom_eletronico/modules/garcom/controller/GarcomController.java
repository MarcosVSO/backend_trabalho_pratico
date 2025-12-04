package com.br.garcom_eletronico.modules.garcom.controller;

import com.br.garcom_eletronico.modules.garcom.dto.GarcomDTO;
import com.br.garcom_eletronico.modules.garcom.service.GarcomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garcons")
@RequiredArgsConstructor
public class GarcomController {

    private final GarcomService service;

    @GetMapping
    public List<GarcomDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GarcomDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GarcomDTO create(@RequestBody GarcomDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public GarcomDTO update(@PathVariable Long id, @RequestBody GarcomDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}