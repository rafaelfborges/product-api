package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProdutoResponseDto;
import com.gft.productapi.resource.docs.ProdutoResourceDocs;
import com.gft.productapi.service.impl.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource implements ProdutoResourceDocs {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ProdutoResponseDto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@Valid @RequestBody ProdutoRequestDto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> update(@PathVariable Long id, 
                                                     @Valid @RequestBody ProdutoRequestDto produto) {
        return ResponseEntity.ok(produtoService.updateById(id, produto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) { 
        produtoService.deleteById(id);
    }
}