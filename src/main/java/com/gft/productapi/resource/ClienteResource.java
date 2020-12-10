package com.gft.productapi.resource;

import java.util.List;

import javax.validation.Valid;

import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.entity.Cliente;
import com.gft.productapi.service.impl.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Clientes")
@RequestMapping("/api/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @ApiOperation("Listar todas os clientes")
    public ResponseEntity<List<ClienteDto>> findAll() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar um cliente pelo id")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarClientePorId(id));
    }

    @PostMapping
    @ApiOperation("Adiciona um novo cliente")
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um cliente")
    public ResponseEntity<Cliente> update(@ApiParam(value = "Id de um cliente", example = "1") @PathVariable Long id, 
                                          @Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.updateById(id, cliente));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove um cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
}
