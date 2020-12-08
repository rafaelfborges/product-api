package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.entity.Produto;
import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.mapper.ProdutoMapper;
import com.gft.productapi.repository.ProdutoRepository;
import com.gft.productapi.service.interfaces.ProdutoServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements ProdutoServiceInterface {

    @Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoMapper produtoMapper;

	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(Long id) {
		return produtoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public List<ProdutoDto> listarProdutos() {
		return produtoMapper.map(this.findAll());
	}

	@Override
	public ProdutoDto listarProdutoPorId(Long id) {
		return produtoMapper.map(this.findById(id));
	}
}
