package com.gft.productapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.gft.productapi.dto.VendaDto;
import com.gft.productapi.entity.Venda;
import com.gft.productapi.mapper.VendaMapper;
import com.gft.productapi.repository.VendaRepository;
import com.gft.productapi.service.interfaces.VendaServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService implements VendaServiceInterface {

    @Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendaMapper vendaMapper;

	@Override
	public Venda save(Venda venda) {
		List<Long> idsProdutos = venda.getProdutos().stream()
									 			    .map(p -> p.getId())
												    .collect(Collectors.toList());

		produtoService.verificarEstoqueProdutos(idsProdutos);
		venda.setTotalCompra(produtoService.somarTotalProdutos(idsProdutos));
		produtoService.diminuirEstoqueProdutos(idsProdutos);
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
	public Venda updateById(Long id, Venda venda) {
		Venda vendaAtual = this.findById(id);
		BeanUtils.copyProperties(venda, vendaAtual, "id");
		return this.save(vendaAtual);
	}

	@Override
	public void deleteById(Long id) {
		vendaRepository.deleteById(id);
	}

	@Override
	public List<VendaDto> listarVendas() {
		return vendaMapper.map(this.findAll());
	}

	@Override
	public VendaDto listarVendaPorId(Long id) {
		return vendaMapper.map(this.findById(id));
	}
}
