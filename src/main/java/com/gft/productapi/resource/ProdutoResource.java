package com.gft.productapi.resource;

import java.util.List;

import javax.validation.Valid;

import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.entity.Produto;
import com.gft.productapi.service.impl.ProdutoService;

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
@Api(tags = "Produtos")
@RequestMapping("/api/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ApiOperation("Listar todas os produtos")
    public ResponseEntity<List<ProdutoDto>> findAll() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/asc")
    @ApiOperation("Buscar todas os produtos em ordem ascendente")
    public ResponseEntity<List<ProdutoDto>> findAllByOrderByNomeAsc() {
        return ResponseEntity.ok(produtoService.findAllByOrderByNomeAsc());
    }

    @GetMapping("/desc")
    @ApiOperation("Buscar todas os produtos em ordem descendente")
    public ResponseEntity<List<ProdutoDto>> findAllByOrderByNomeDesc() {
        return ResponseEntity.ok(produtoService.findAllByOrderByNomeDesc());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar um produto pelo id")
    public ResponseEntity<ProdutoDto> findById(@ApiParam(value = "Id de um produto", example = "1") 
                                               @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarProdutoPorId(id));
    }

    @GetMapping("/nome/{nome}")
    @ApiOperation("Buscar um produto pelo nome")
    public ResponseEntity<ProdutoDto> findByNome(@ApiParam(value = "Nome de um produto", example = "Notebook") 
                                                 @PathVariable String nome) {
        return ResponseEntity.ok(produtoService.findByNome(nome));
    }

    @PostMapping
    @ApiOperation("Adiciona um novo produto")
    public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um produto")
    public ResponseEntity<Produto> update(@ApiParam(value = "Id de um produto", example = "1") @PathVariable Long id, 
                                          @Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.updateById(id, produto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove um produto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) { 
        produtoService.deleteById(id);
    }
}
