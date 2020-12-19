package com.gft.productapi.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T, S> {
    
    T save(S t);

    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T findByNome(String nome);

    T updateById(Long id, S t);

    void deleteById(Long id);
}
