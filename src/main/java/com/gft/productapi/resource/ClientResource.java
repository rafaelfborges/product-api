package com.gft.productapi.resource;

import com.gft.productapi.dto.request.ClientRequestDto;
import com.gft.productapi.dto.response.ClientResponseDto;
import com.gft.productapi.resource.docs.ClientResourceDocs;
import com.gft.productapi.service.impl.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientResource implements ClientResourceDocs {

    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClientResponseDto> findAll(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto findByName(@PathVariable String name) {
        return clientService.findByName(name);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto create(@Valid @RequestBody ClientRequestDto client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto update(@PathVariable Long id, @Valid @RequestBody ClientRequestDto client) {
        return clientService.updateById(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
