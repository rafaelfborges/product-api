package com.gft.productapi.service.impl;

import com.gft.productapi.dto.request.SupplierRequestDto;
import com.gft.productapi.dto.response.SupplierResponseDto;
import com.gft.productapi.entity.Supplier;
import com.gft.productapi.exception.ResourceNotFoundException;
import com.gft.productapi.mapper.SupplierMapper;
import com.gft.productapi.repository.SupplierRepository;
import com.gft.productapi.service.interfaces.SupplierServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierService implements SupplierServiceInterface {

    private final SupplierMapper mapper;
    private final SupplierRepository repository;

    @Override
    public SupplierResponseDto save(SupplierRequestDto fornecedorDto) {
        Supplier supplier = mapper.mapRequest(fornecedorDto);
        return mapper.mapResponse(repository.save(supplier));
    }

    @Override
    public Page<SupplierResponseDto> findAll(Pageable pageable) {
        Page<Supplier> suppliers = repository.findAll(pageable);
        return new PageImpl<>(mapper.mapResponse(suppliers.getContent()),
                suppliers.getPageable(),
                suppliers.getTotalElements());
    }

    @Override
    public SupplierResponseDto findById(Long id) {
        Supplier supplier = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.mapResponse(supplier);
    }

    @Override
    public SupplierResponseDto findByName(String name) {
        Supplier supplier = repository.findByNameIgnoreCaseContaining(name).orElseThrow(ResourceNotFoundException::new);
        return mapper.mapResponse(supplier);
    }

    @Override
    public SupplierResponseDto updateById(Long id, SupplierRequestDto fornecedorDto) {
        Supplier supplier = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(fornecedorDto, supplier, "id");
        return mapper.mapResponse(repository.save(supplier));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
