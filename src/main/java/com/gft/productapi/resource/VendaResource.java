package com.gft.productapi.resource;

import java.util.List;

import javax.validation.Valid;

import com.gft.productapi.dto.VendaDto;
import com.gft.productapi.entity.Venda;
import com.gft.productapi.service.impl.VendaService;

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
@Api(tags = "Vendas")
@RequestMapping("/api/vendas")
public class VendaResource{
    
    @Autowired
    private VendaService vendaService;

    @GetMapping
    @ApiOperation("Listar todas as vendas")
    public ResponseEntity<List<VendaDto>> findAll() {
        return ResponseEntity.ok(vendaService.listarVendas());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar uma venda pelo id")
    public ResponseEntity<VendaDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.listarVendaPorId(id));
    }

    @PostMapping
    @ApiOperation("Adicionar uma nova venda")
    public ResponseEntity<Venda> create(@Valid @RequestBody Venda venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(venda));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma venda")
    public ResponseEntity<Venda> update(@ApiParam(value = "Id de uma venda") @PathVariable Long id, 
                                          @Valid @RequestBody Venda venda) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove uma venda")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        vendaService.deleteById(id);
    }
}
