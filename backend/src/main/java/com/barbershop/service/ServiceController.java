package com.barbershop.service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = {
    "https://barbershop-app-lake.vercel.app"
})
public class ServiceController {

    private final ServiceRepository repository;

    public ServiceController(ServiceRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Service create(
        @RequestBody Service service,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return null;

        service.setTenantId(tenantId);
        return repository.save(service);
    }

    @GetMapping
    public List<Service> list(
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return new ArrayList<>();

        return repository.findByTenantId(tenantId);
    }
}