package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.entity.Empresa;
import com.gft.productapi.repository.EmpresaRepository;
import com.gft.productapi.service.interfaces.EmpresaServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService implements EmpresaServiceInterface {
    
    @Autowired
    private EmpresaRepository empresaRepository;

	@Override
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa findById(Long id) {
		return empresaRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteById(Long id) {
		empresaRepository.deleteById(id);
	}    
}
