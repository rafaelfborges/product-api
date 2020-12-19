package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.FornecedorRequestDto;
import com.gft.productapi.dto.response.FornecedorResponseDto;
import com.gft.productapi.resource.docs.FornecedorResouceDocs;
import com.gft.productapi.service.impl.FornecedorService;

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
@RequestMapping("/api/fornecedores")
public class FornecedorResouce implements FornecedorResouceDocs {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<Page<FornecedorResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(fornecedorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<FornecedorResponseDto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(fornecedorService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<FornecedorResponseDto> create(@Valid @RequestBody FornecedorRequestDto fornecedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.save(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDto> update(@PathVariable Long id, 
                                                        @Valid @RequestBody FornecedorRequestDto fornecedor) {
        return ResponseEntity.ok(fornecedorService.updateById(id, fornecedor));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        fornecedorService.deleteById(id);
    }
}
