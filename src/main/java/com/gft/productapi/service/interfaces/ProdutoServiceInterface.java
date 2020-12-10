package com.gft.productapi.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.entity.Produto;

public interface ProdutoServiceInterface extends ServiceInterface<Produto> {
    
    List<ProdutoDto> listarProdutos();

    ProdutoDto listarProdutoPorId(Long id);

    BigDecimal somarTotalProdutos(List<Long> ids);

    void diminuirEstoqueProdutos(List<Long> ids);

    void verificarEstoqueProdutos(List<Long> ids);
}

