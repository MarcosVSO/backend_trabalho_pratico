package com.br.garcom_eletronico.modules.pedido.service;

import com.br.garcom_eletronico.common.exception.ResourceNotFoundException;
import com.br.garcom_eletronico.modules.cliente.Cliente;
import com.br.garcom_eletronico.modules.cliente.repository.ClienteRepository;
import com.br.garcom_eletronico.modules.conta.Conta;
import com.br.garcom_eletronico.modules.conta.repository.ContaRepository;
import com.br.garcom_eletronico.modules.pedido.Pedido;
import com.br.garcom_eletronico.modules.pedido.dto.PedidoDTO;
import com.br.garcom_eletronico.modules.pedido.mapper.PedidoMapper;
import com.br.garcom_eletronico.modules.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    public List<PedidoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public PedidoDTO findById(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public PedidoDTO create(PedidoDTO dto) {
        Pedido entity = mapper.toEntity(dto);
        entity.setId(null);
        entity.setCliente(resolveCliente(dto.getClienteId()));
        entity.setConta(resolveConta(dto.getContaId()));
        return mapper.toDto(repository.save(entity));
    }

    public PedidoDTO update(Long id, PedidoDTO dto) {
        Pedido entity = getEntity(id);
        mapper.updateEntityFromDto(dto, entity);
        entity.setCliente(resolveCliente(dto.getClienteId()));
        entity.setConta(resolveConta(dto.getContaId()));
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        Pedido entity = getEntity(id);
        repository.delete(entity);
    }

    private Pedido getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found with id " + id));
    }

    private Cliente resolveCliente(Long clienteId) {
        if (clienteId == null) {
            throw new ResourceNotFoundException("Cliente id is required");
        }
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found with id " + clienteId));
    }

    private Conta resolveConta(Integer contaId) {
        if (contaId == null) {
            return null;
        }
        return contaRepository.findById(contaId)
                .orElseThrow(() -> new ResourceNotFoundException("Conta not found with id " + contaId));
    }
}

