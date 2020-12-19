package com.gft.productapi.resource;

import javax.validation.Valid;

import com.gft.productapi.dto.request.ClienteRequestDto;
import com.gft.productapi.dto.response.ClienteResponseDto;
import com.gft.productapi.resource.docs.ClienteResourceDocs;
import com.gft.productapi.service.impl.ClienteService;

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
@RequestMapping("/api/clientes")
public class ClienteResource implements ClienteResourceDocs {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(clienteService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ClienteResponseDto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(@Valid @RequestBody ClienteRequestDto cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto cliente) {
        return ResponseEntity.ok(clienteService.updateById(id, cliente));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
}
