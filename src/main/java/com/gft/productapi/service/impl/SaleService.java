package com.gft.productapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;
import com.gft.productapi.entity.Product;
import com.gft.productapi.entity.Sale;
import com.gft.productapi.exception.ResourceNotFoundException;
import com.gft.productapi.mapper.SaleMapper;
import com.gft.productapi.repository.SaleRepository;
import com.gft.productapi.service.interfaces.SaleServiceInterface;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaleService implements SaleServiceInterface {

	private final SaleMapper mapper;
	private final SaleRepository repository;
	private final ProductService productService;
	
	@Override
	public SaleResponseDto save(SaleRequestDto vendaDto) {
		Sale sale = mapper.mapRequest(vendaDto);

		List<Long> idsProducts = sale.getProducts().stream()
									 			    .map(Product::getId)
												    .collect(Collectors.toList());

		productService.verifyStockProducts(idsProducts);
		sale.setTotalSale(productService.sumTotalProducts(idsProducts));
		productService.decreaseStockProducts(idsProducts);
		return mapper.mapResponse(repository.save(sale));
	}

	@Override
	public Page<SaleResponseDto> findAll(Pageable pageable) {
		Page<Sale> sales = repository.findAll(pageable);
		return new PageImpl<>(mapper.mapResponse(sales.getContent()), 
							  sales.getPageable(),
							  sales.getTotalElements());
	}

	@Override
	public SaleResponseDto findById(Long id) {
		return mapper.mapResponse(repository.findById(id)
											.orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public SaleResponseDto findByNome(String name) {
		return mapper.mapResponse(repository.findSaleByClientNameContainingIgnoreCase(name)
											.orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public SaleResponseDto updateById(Long id, SaleRequestDto vendaDto) {
		Sale sale = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
		BeanUtils.copyProperties(vendaDto, sale, "id");
		return mapper.mapResponse(repository.save(sale));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
