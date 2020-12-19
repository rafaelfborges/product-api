package com.gft.productapi.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.gft.productapi.entity.Produto;
import com.gft.productapi.exception.ProdutoSemEstoqueException;
import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProdutoResponseDto;
import com.gft.productapi.mapper.ProdutoMapper;
import com.gft.productapi.repository.ProdutoRepository;
import com.gft.productapi.service.interfaces.ProdutoServiceInterface;

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
public class ProdutoService implements ProdutoServiceInterface {

	private final ProdutoMapper mapper;
	private final ProdutoRepository repository;
	
	@Override
	public ProdutoResponseDto save(ProdutoRequestDto produtoDto) {
		Produto produto = mapper.mapRequest(produtoDto);
		return mapper.mapResponse(repository.save(produto));
	}

	@Override
	public Page<ProdutoResponseDto> findAll(Pageable pageable) {
		Page<Produto> produtos = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(produtos.getContent()),
							  produtos.getPageable(), 
							  produtos.getTotalElements());
	}

	@Override
	public ProdutoResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id)
													   .orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public ProdutoResponseDto findByNome(String nome) {
		return mapper.mapResponse(repository.findByNomeIgnoreCaseContaining(nome)
													   .orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public ProdutoResponseDto updateById(Long id, ProdutoRequestDto produtoDto) {
		Produto produto = repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(produtoDto, produto, "id");
		return mapper.mapResponse(repository.save(produto));
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public BigDecimal somarTotalProdutos(List<Long> ids) {
		return repository.findAllById(ids).stream()
												 .map(Produto::getValor)
								                 .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public void diminuirEstoqueProdutos(List<Long> ids) {
		List<Produto> produtos = repository.findAllById(ids);
		produtos.forEach(Produto::diminuirQuantidade);
		repository.saveAll(produtos);
	}

	@Override
	public void verificarEstoqueProdutos(List<Long> ids) {
		for(Produto p : repository.findAllById(ids)) {
			if(p.getQuantidade().intValue() <= 0 )
				throw new ProdutoSemEstoqueException(p.getNome());
		}				 
	}
}
