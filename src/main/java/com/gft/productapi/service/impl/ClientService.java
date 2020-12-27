package com.gft.productapi.service.impl;

import com.gft.productapi.dto.request.ClientRequestDto;
import com.gft.productapi.dto.response.ClientResponseDto;
import com.gft.productapi.entity.Client;
import com.gft.productapi.exception.ResourceNotFoundException;
import com.gft.productapi.mapper.ClientMapper;
import com.gft.productapi.repository.ClientRepository;
import com.gft.productapi.service.interfaces.ClientServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService implements ClientServiceInterface {

	private final ClientMapper mapper;
	private final ClientRepository repository;

	@Override
	public ClientResponseDto save(ClientRequestDto clienteDto) {
		Client client = mapper.mapRequest(clienteDto);
		return mapper.mapResponse(repository.save(client));
	}

	@Override
	public Page<ClientResponseDto> findAll(Pageable pageable) {
		Page<Client> clients = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(clients.getContent()), 
							  clients.getPageable(), 
							  clients.getTotalElements());
	}

	@Override
	public ClientResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public ClientResponseDto findByName(String name) {
		Client client = repository.findByNameIgnoreCaseContaining(name)
									.orElseThrow(ResourceNotFoundException::new);
		return mapper.mapResponse(client);
	}

	@Override
	public ClientResponseDto updateById(Long id, ClientRequestDto clienteDto) {
		Client client = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
		BeanUtils.copyProperties(clienteDto, client, "id");
		return mapper.mapResponse(repository.save(client));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}