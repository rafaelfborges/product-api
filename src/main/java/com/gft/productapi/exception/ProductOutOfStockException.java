package com.gft.productapi.exception;

public class ProductOutOfStockException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    
    public ProductOutOfStockException(String productName) {
        super("Produto " + productName + ", está sem estoque!");
    }
}
