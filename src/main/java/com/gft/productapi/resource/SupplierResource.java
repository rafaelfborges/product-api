package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.SupplierRequestDto;
import com.gft.productapi.dto.response.SupplierResponseDto;
import com.gft.productapi.resource.docs.SupplierResouceDocs;
import com.gft.productapi.service.impl.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fornecedores")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierResource implements SupplierResouceDocs {

    private final SupplierService supplierService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SupplierResponseDto> findAll(Pageable pageable) {
        return supplierService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierResponseDto findById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierResponseDto findByName(@PathVariable String name) {
        return supplierService.findByName(name);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierResponseDto create(@Valid @RequestBody SupplierRequestDto supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SupplierResponseDto update(@PathVariable Long id,
                                                      @Valid @RequestBody SupplierRequestDto supplier) {
        return supplierService.updateById(id, supplier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        supplierService.deleteById(id);
    }
}
