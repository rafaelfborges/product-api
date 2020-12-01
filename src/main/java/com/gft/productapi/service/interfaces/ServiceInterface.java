package com.gft.productapi.service.interfaces;

import java.util.List;

public interface ServiceInterface<T> {
    
    T save(T t);

    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);
}
