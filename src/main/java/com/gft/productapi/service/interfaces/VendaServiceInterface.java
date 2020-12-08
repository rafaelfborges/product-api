package com.gft.productapi.service.interfaces;

import java.util.List;

import com.gft.productapi.dto.VendaDto;
import com.gft.productapi.entity.Venda;

public interface VendaServiceInterface extends ServiceInterface<Venda> {
    
    List<VendaDto> listarVendas();

    VendaDto listarVendaPorId(Long id);
}
