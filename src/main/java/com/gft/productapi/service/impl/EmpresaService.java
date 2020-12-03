package com.gft.productapi.service.impl;

import java.util.List;

import com.gft.productapi.entity.Empresa;
import com.gft.productapi.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }
}
