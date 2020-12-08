package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.entity.Venda;
import com.gft.productapi.repository.VendaRepository;
import com.gft.productapi.service.interfaces.VendaServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;

public class VendaService implements VendaServiceInterface {

    @Autowired
    private VendaRepository vendaRepository;

	@Override
	public Venda save(Venda venda) {
		return vendaRepository.save(venda);
	}

	@Override
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}

	@Override
	public Venda findById(Long id) {
		return vendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteById(Long id) {
		vendaRepository.deleteById(id);
	}
    
    
}
