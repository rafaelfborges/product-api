package com.gft.productapi.resource;

import java.util.List;

import javax.validation.Valid;

import com.gft.productapi.entity.Empresa;
import com.gft.productapi.service.impl.EmpresaService;

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
@Api(tags = "Empresas")
@RequestMapping("/api/empresas")
public class EmpresaResouce {
    
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    @ApiOperation("Listar todas as empresas")
    public ResponseEntity<List<Empresa>> findAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar uma empresa pelo id")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    @ApiOperation("Adiciona uma nova empresa")
    public ResponseEntity<Empresa> create(@Valid @RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma empresa")
    public ResponseEntity<Empresa> update(@ApiParam(value = "Id de uma empresa") @PathVariable Long id, 
                                          @Valid @RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.updateById(id, empresa));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove uma empresa")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        empresaService.deleteById(id);
    }
}
