package com.gft.productapi.service.impl;

import com.gft.productapi.dto.request.FornecedorRequestDto;
import com.gft.productapi.dto.response.FornecedorResponseDto;
import com.gft.productapi.entity.Fornecedor;
import com.gft.productapi.mapper.FornecedorMapper;
import com.gft.productapi.repository.FornecedorRepository;
import com.gft.productapi.service.interfaces.FornecedorServiceInterface;

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
public class FornecedorService implements FornecedorServiceInterface {
	
	private final FornecedorMapper mapper;
    private final FornecedorRepository repository;

	@Override
	public FornecedorResponseDto save(FornecedorRequestDto fornecedorDto) {
		Fornecedor fornecedor = mapper.mapRequest(fornecedorDto);
		return mapper.mapResponse(repository.save(fornecedor));
	}

	@Override
	public Page<FornecedorResponseDto> findAll(Pageable pageable) {
		Page<Fornecedor> fornecedores = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(fornecedores.getContent()),
							  fornecedores.getPageable(), 
							  fornecedores.getTotalElements());
	}

	@Override
	public FornecedorResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id)
											.orElseThrow(() -> new EmptyResultDataAccessException(1)));
	}

	@Override
	public FornecedorResponseDto findByNome(String nome) {
		Fornecedor fornecedor = repository.findByNomeIgnoreCaseContaining(nome)
										  .orElseThrow(() -> new EmptyResultDataAccessException(1));
		return mapper.mapResponse(fornecedor);
	}

	@Override
	public FornecedorResponseDto updateById(Long id, FornecedorRequestDto fornecedorDto) {
		Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(fornecedorDto, fornecedor, "id");
		return mapper.mapResponse(repository.save(fornecedor));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
