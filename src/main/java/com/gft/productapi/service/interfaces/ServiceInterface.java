package com.gft.productapi.service.interfaces;

import java.util.List;

public interface ServiceInterface<T> {
    
    Object save(T t);

    List<T> findAll();

    List<?> findAllByOrderByNomeAsc();

    List<?> findAllByOrderByNomeDesc();

    T findById(Long id);

    Object findByNome(String nome);

    T updateById(Long id, T t);

    void deleteById(Long id);
}
