package com.gft.productapi.resource;

import java.util.List;

import javax.validation.Valid;

import com.gft.productapi.entity.Fornecedor;
import com.gft.productapi.service.impl.FornecedorService;

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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Fornecedores")
@RequestMapping("/api/fornecedores")
public class FornecedorResouce {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    @ApiOperation("Listar todas os fornecedores")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.ok(fornecedorService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar um fornecedor pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<Fornecedor> findById(@ApiParam(value = "Id de um fornecedor", example = "1")
                                            @PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    @ApiOperation("Buscar um fornecedor pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<Fornecedor> findByNome(@ApiParam(value = "Nome de um fornecedor", example = "Amazon")
                                              @PathVariable String nome) {
        return ResponseEntity.ok(fornecedorService.findByNome(nome));
    }

    @GetMapping("/asc")
    @ApiOperation("Buscar todas os fornecedores em ordem ascendente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<List<Fornecedor>> findAllByOrderByNomeAsc() {
        return ResponseEntity.ok(fornecedorService.findAllByOrderByNomeAsc());
    }

    @GetMapping("/desc")
    @ApiOperation("Buscar todas os fornecedores em ordem descendente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<List<Fornecedor>> findAllByOrderByNomeDesc() {
        return ResponseEntity.ok(fornecedorService.findAllByOrderByNomeDesc());
    }

    @PostMapping
    @ApiOperation("Adiciona um novo fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<Fornecedor> create(@Valid @RequestBody Fornecedor fornecedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.save(fornecedor));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public ResponseEntity<Fornecedor> update(@ApiParam(value = "Id de um fornecedor", example = "1") @PathVariable Long id,
                                             @Valid @RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.updateById(id, fornecedor));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove um fornecedor")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    public void remove(@PathVariable Long id) {
        fornecedorService.deleteById(id);
    }
}
