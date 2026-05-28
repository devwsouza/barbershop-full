package com.barbershop.client;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = {
    "https://barbershop-app-lake.vercel.app"
})
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Client create(
        @RequestBody Client client,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return null;

        client.setTenantId(tenantId);
        return repository.save(client);
    }

    @GetMapping
    public List<Client> list(
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return new ArrayList<>();

        return repository.findByTenantId(tenantId);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }

}