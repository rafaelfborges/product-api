package com.gft.productapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gft.productapi.dto.request.VendaRequestDto;
import com.gft.productapi.dto.response.VendaResponseDto;
import com.gft.productapi.entity.Produto;
import com.gft.productapi.entity.Venda;
import com.gft.productapi.mapper.VendaMapper;
import com.gft.productapi.repository.VendaRepository;
import com.gft.productapi.service.interfaces.VendaServiceInterface;

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
public class VendaService implements VendaServiceInterface {

	private final VendaMapper mapper;
	private final VendaRepository repository;
	private final ProdutoService produtoService;
	
	@Override
	public VendaResponseDto save(VendaRequestDto vendaDto) {
		Venda venda = mapper.mapRequest(vendaDto);

		List<Long> idsProdutos = venda.getProdutos().stream()
									 			    .map(Produto::getId)
												    .collect(Collectors.toList());

		produtoService.verificarEstoqueProdutos(idsProdutos);
		venda.setTotalCompra(produtoService.somarTotalProdutos(idsProdutos));
		produtoService.diminuirEstoqueProdutos(idsProdutos);
		return mapper.mapResponse(repository.save(venda));
	}

	@Override
	public Page<VendaResponseDto> findAll(Pageable pageable) {
		Page<Venda> vendas = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(vendas.getContent()), 
							  vendas.getPageable(),
							  vendas.getTotalElements());
	}

	@Override
	public VendaResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id)
											.orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public VendaResponseDto findByNome(String nome) {
		return mapper.mapResponse(repository.findVendaByClienteNomeContainingIgnoreCase(nome)
											.orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public VendaResponseDto updateById(Long id, VendaRequestDto vendaDto) {
		Venda venda = repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(vendaDto, venda, "id");
		return mapper.mapResponse(repository.save(venda));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
