package com.br.garcom_eletronico.modules.pagamento.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.pagamento.Pagamento;
import com.br.garcom_eletronico.modules.pagamento.dto.PagamentoDTO;
import com.br.garcom_eletronico.modules.pagamento.mapper.PagamentoMapper;
import com.br.garcom_eletronico.modules.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;
    private final PagamentoMapper mapper;

    public List<PagamentoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public PagamentoDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public PagamentoDTO create(PagamentoDTO dto) {
        Pagamento entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public PagamentoDTO update(Long id, PagamentoDTO dto) {
        Pagamento entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        Pagamento entity = getEntity(id);
        repository.delete(entity);
    }

    private Pagamento getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado com id " + id));
    }
}