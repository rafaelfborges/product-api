package com.gft.productapi.resource;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;
import com.gft.productapi.resource.docs.SaleResourceDocs;
import com.gft.productapi.service.impl.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public SaleResponseDto findByName(@PathVariable String name) {
        return saleService.findByName(name);
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