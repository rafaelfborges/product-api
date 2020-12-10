package com.gft.productapi.exceptions;

public class ProdutoSemEstoqueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    
    public ProdutoSemEstoqueException(String nomeProduto) {
        super("Produto " + nomeProduto + ", está sem estoque!");
    }
}
