package com.gft.productapi.service.interfaces;

import java.util.List;

import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.entity.Cliente;

public interface ClienteServiceInterface extends ServiceInterface<Cliente> {
    
    List<ClienteDto> listarClientes();
}
