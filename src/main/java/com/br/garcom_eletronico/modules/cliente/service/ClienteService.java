package com.br.garcom_eletronico.modules.cliente.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.cliente.Cliente;
import com.br.garcom_eletronico.modules.cliente.dto.ClienteDTO;
import com.br.garcom_eletronico.modules.cliente.mapper.ClienteMapper;
import com.br.garcom_eletronico.modules.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public List<ClienteDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ClienteDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public ClienteDTO create(ClienteDTO dto) {
        Cliente entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        Cliente entity = getEntity(id);
        repository.delete(entity);
    }

    private Cliente getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found with id " + id));
    }

    public ClienteDTO sortearCliente() {
        Cliente cliente = repository.findRandomCliente()
                .orElseThrow(() -> new ResourceNotFoundException("No clients found"));
        return mapper.toDto(cliente);
    }

    public List<ClienteDTO> findAniversariantes() {
        LocalDate hoje = LocalDate.now();
        int diaHoje = hoje.getDayOfMonth();
        int mesHoje = hoje.getMonthValue();

        return repository.findAniversariantes(diaHoje, mesHoje)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}


