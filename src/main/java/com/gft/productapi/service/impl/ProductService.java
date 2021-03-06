package com.gft.productapi.service.impl;

import com.gft.productapi.dto.request.ProductRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;
import com.gft.productapi.entity.Product;
import com.gft.productapi.exception.ProductOutOfStockException;
import com.gft.productapi.exception.ResourceNotFoundException;
import com.gft.productapi.mapper.ProductMapper;
import com.gft.productapi.repository.ProductRepository;
import com.gft.productapi.service.interfaces.ProductServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService implements ProductServiceInterface {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public ProductResponseDto save(ProductRequestDto produtoDto) {
        Product product = mapper.mapRequest(produtoDto);
        return mapper.mapResponse(repository.save(product));
    }

    @Override
    public Page<ProductResponseDto> findAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return new PageImpl<>(mapper.mapResponse(products.getContent()),
                products.getPageable(),
                products.getTotalElements());
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.mapResponse(product);
    }

    @Override
    public ProductResponseDto findByName(String name) {
        Product product = repository.findByNameIgnoreCaseContaining(name).orElseThrow(ResourceNotFoundException::new);
        return mapper.mapResponse(product);
    }

    @Override
    public ProductResponseDto updateById(Long id, ProductRequestDto produtoDto) {
        Product product = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(produtoDto, product, "id");
        return mapper.mapResponse(repository.save(product));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BigDecimal sumTotalProducts(List<Long> ids) {
        return repository.findAllById(ids).stream()
                .map(Product::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void decreaseStockProducts(List<Long> ids) {
        List<Product> products = repository.findAllById(ids);
        products.forEach(Product::decreaseQuantity);
        repository.saveAll(products);
    }

    @Override
    public void verifyStockProducts(List<Long> ids) {
        for (Product p : repository.findAllById(ids)) {
            if (p.getQuantity().intValue() <= 0)
                throw new ProductOutOfStockException(p.getName());
        }
    }
}
