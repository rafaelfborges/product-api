package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;
import com.gft.productapi.resource.docs.SaleResourceDocs;
import com.gft.productapi.service.impl.SaleService;

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
@RequestMapping("/api/vendas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaleResource implements SaleResourceDocs {

    private final SaleService saleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SaleResponseDto> findAll(Pageable pageable) {
        return saleService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleResponseDto findById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public SaleResponseDto findByNome(@PathVariable String name) {
        return saleService.findByNome(name);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public SaleResponseDto create(@Valid @RequestBody SaleRequestDto sale) {
        return saleService.save(sale);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SaleResponseDto update(@PathVariable Long id, @Valid @RequestBody SaleRequestDto sale) {
        return saleService.updateById(id, sale);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        saleService.deleteById(id);
    }
}