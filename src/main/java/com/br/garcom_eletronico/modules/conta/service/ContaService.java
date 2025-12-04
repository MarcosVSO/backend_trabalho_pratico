package com.br.garcom_eletronico.modules.conta.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.conta.Conta;
import com.br.garcom_eletronico.modules.conta.dto.ContaDTO;
import com.br.garcom_eletronico.modules.conta.mapper.ContaMapper;
import com.br.garcom_eletronico.modules.conta.repository.ContaRepository;
import com.br.garcom_eletronico.modules.pagamento.Pagamento;
import com.br.garcom_eletronico.modules.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;
    private final ContaMapper mapper;
    private final PagamentoRepository pagamentoRepository;

    public List<ContaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContaDTO findById(Integer id) {
        return mapper.toDto(getEntity(id));
    }

    public ContaDTO create(ContaDTO dto) {
        Conta entity = mapper.toEntity(dto);
        entity.setId(null);
        entity.setPagamento(resolvePagamento(dto.getPagamentoId()));
        return mapper.toDto(repository.save(entity));
    }

    public ContaDTO update(Integer id, ContaDTO dto) {
        Conta entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        entity.setPagamento(resolvePagamento(dto.getPagamentoId()));
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        Conta entity = getEntity(id);
        repository.delete(entity);
    }

    private Conta getEntity(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada com id " + id));
    }

    private Pagamento resolvePagamento(Long pagamentoId) {
        if (pagamentoId == null) {
            return null;
        }
        return pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrada com id " + pagamentoId));
    }
}