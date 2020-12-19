package com.gft.productapi.service.impl;

import com.gft.productapi.dto.request.ClienteRequestDto;
import com.gft.productapi.dto.response.ClienteResponseDto;
import com.gft.productapi.entity.Cliente;
import com.gft.productapi.mapper.ClienteMapper;
import com.gft.productapi.repository.ClienteRepository;
import com.gft.productapi.service.interfaces.ClienteServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService implements ClienteServiceInterface {

	private final ClienteMapper mapper;
	private final ClienteRepository repository;

	@Override
	public ClienteResponseDto save(ClienteRequestDto clienteDto) {
		Cliente cliente = mapper.mapRequest(clienteDto);
		return mapper.mapResponse(repository.save(cliente));
	}

	@Override
	public Page<ClienteResponseDto> findAll(Pageable pageable) {
		Page<Cliente> clientes = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(clientes.getContent()), 
							  clientes.getPageable(), 
							  clientes.getTotalElements());
	}

	@Override
	public ClienteResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public ClienteResponseDto findByNome(String nome) {
		Cliente cliente = repository.findByNomeIgnoreCaseContaining(nome)
									.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return mapper.mapResponse(cliente);
	}

	@Override
	public ClienteResponseDto updateById(Long id, ClienteRequestDto clienteDto) {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(clienteDto, cliente, "id");
		return mapper.mapResponse(repository.save(cliente));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}