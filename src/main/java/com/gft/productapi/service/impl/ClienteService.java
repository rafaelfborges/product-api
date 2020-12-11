package com.gft.productapi.service.impl;

import java.util.List;

import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.entity.Cliente;
import com.gft.productapi.mapper.ClienteMapper;
import com.gft.productapi.repository.ClienteRepository;
import com.gft.productapi.service.interfaces.ClienteServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public List<ClienteDto> findAllByOrderByNomeAsc() {
		return clienteMapper.map(clienteRepository.findAllByOrderByNomeAsc());
	}

	@Override
	public List<ClienteDto> findAllByOrderByNomeDesc() {
		return clienteMapper.map(clienteRepository.findAllByOrderByNomeDesc());
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public ClienteDto findByNome(String nome) {
		return clienteMapper.map(clienteRepository.findByNomeIgnoreCaseContaining(nome)
												  .orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public Cliente updateById(Long id, Cliente cliente) {
		Cliente clienteAtual = this.findById(id);
		BeanUtils.copyProperties(cliente, clienteAtual, "id");
		return this.save(clienteAtual);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public List<ClienteDto> listarClientes() {
		return clienteMapper.map(this.findAll());
	}

	@Override
	public ClienteDto listarClientePorId(Long id) {
		return clienteMapper.map(this.findById(id));
	}
}