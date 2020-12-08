package com.gft.productapi.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import com.gft.productapi.dto.VendaDto;
import com.gft.productapi.entity.Venda;
import com.gft.productapi.mapper.VendaMapper;
import com.gft.productapi.repository.VendaRepository;
import com.gft.productapi.service.interfaces.VendaServiceInterface;

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
		BigDecimal valorTotal = venda.getProdutos()
										.stream()
										.map(p -> produtoService.findById(p.getId()).getValor())
										.reduce(BigDecimal.ZERO, BigDecimal::add);

		venda.setTotalCompra(valorTotal);
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

	@Override
	public List<VendaDto> listarVendas() {
		return vendaMapper.map(this.findAll());
	}

	@Override
	public VendaDto listarVendaPorId(Long id) {
		return vendaMapper.map(this.findById(id));
	}
}
