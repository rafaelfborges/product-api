package com.gft.productapi.resource;

import com.gft.productapi.dto.request.ProductRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;
import com.gft.productapi.resource.docs.ProductResourceDocs;
import com.gft.productapi.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductResource implements ProductResourceDocs {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductResponseDto> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto create(@Valid @RequestBody ProductRequestDto product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto update(@PathVariable Long id, @Valid @RequestBody ProductRequestDto product) {
        return productService.updateById(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        productService.deleteById(id);
    }
}