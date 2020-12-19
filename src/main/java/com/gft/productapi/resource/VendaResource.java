package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.VendaRequestDto;
import com.gft.productapi.dto.response.VendaResponseDto;
import com.gft.productapi.resource.docs.VendaResourceDocs;
import com.gft.productapi.service.impl.VendaService;

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
@RequestMapping("/api/vendas")
public class VendaResource implements VendaResourceDocs {
    
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<Page<VendaResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(vendaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<VendaResponseDto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(vendaService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<VendaResponseDto> create(@Valid @RequestBody VendaRequestDto venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(venda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaResponseDto> update(@PathVariable Long id, 
                                                   @Valid @RequestBody VendaRequestDto venda) {
        return ResponseEntity.ok(vendaService.updateById(id, venda));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        vendaService.deleteById(id);
    }
}