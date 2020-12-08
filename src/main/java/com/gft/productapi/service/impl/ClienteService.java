package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.entity.Cliente;
import com.gft.productapi.mapper.ClienteMapper;
import com.gft.productapi.repository.ClienteRepository;
import com.gft.productapi.service.interfaces.ClienteServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public List<ClienteDto> listarClientes() {
		return clienteMapper.map(this.findAll());
	}
}