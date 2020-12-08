package com.gft.productapi.service.interfaces;

import java.util.List;

import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.entity.Produto;

public interface ProdutoServiceInterface extends ServiceInterface<Produto> {
    
    List<ProdutoDto> listarProdutos();
}

