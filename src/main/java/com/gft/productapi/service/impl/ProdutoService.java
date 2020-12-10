package com.gft.productapi.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.entity.Produto;
import com.gft.productapi.exception.ProdutoSemEstoqueException;
import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.mapper.ProdutoMapper;
import com.gft.productapi.repository.ProdutoRepository;
import com.gft.productapi.service.interfaces.ProdutoServiceInterface;

import org.springframework.beans.BeanUtils;
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
	public Produto updateById(Long id, Produto produto) {
		Produto produtoAtual = this.findById(id);
		BeanUtils.copyProperties(produto, produtoAtual, "id");
		return this.save(produtoAtual);
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

	@Override
	public BigDecimal somarTotalProdutos(List<Long> ids) {
		return produtoRepository.findAllById(ids).stream()
												 .map(p -> p.getValor())
								                 .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public void diminuirEstoqueProdutos(List<Long> ids) {
		List<Produto> produtos = produtoRepository.findAllById(ids);
		produtos.forEach(p -> p.diminuirQuantidade());
		produtoRepository.saveAll(produtos);
	}

	@Override
	public void verificarEstoqueProdutos(List<Long> ids) {
		for(Produto p : produtoRepository.findAllById(ids)) {
			if(p.getQuantidade().intValue() <= 0 )
				throw new ProdutoSemEstoqueException(p.getNome());
		}				 
	}
}
