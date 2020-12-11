package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.entity.Fornecedor;
import com.gft.productapi.repository.FornecedorRepository;
import com.gft.productapi.service.interfaces.FornecedorServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService implements FornecedorServiceInterface {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	public List<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}

	@Override
	public List<Fornecedor> findAllByOrderByNomeAsc() {
		return fornecedorRepository.findAllByOrderByNomeAsc();
	}

	@Override
	public List<Fornecedor> findAllByOrderByNomeDesc() {
		return fornecedorRepository.findAllByOrderByNomeDesc();
	}

	@Override
	public Fornecedor findById(Long id) {
		return fornecedorRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Fornecedor findByNome(String nome) {
		return fornecedorRepository.findByNomeIgnoreCaseContaining(nome).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Fornecedor updateById(Long id, Fornecedor fornecedor) {
		Fornecedor fornecedorAtual = this.findById(id);
		BeanUtils.copyProperties(fornecedor, fornecedorAtual, "id");
		return this.save(fornecedorAtual);
	}

	@Override
	public void deleteById(Long id) {
		fornecedorRepository.deleteById(id);
	}
}
