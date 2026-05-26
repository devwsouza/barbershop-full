package com.barbershop.appointment;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = {
    "https://barbershop-app-lake.vercel.app"
})
public class AppointmentController {

    private final AppointmentRepository repository;

    public AppointmentController(AppointmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Appointment create(
        @RequestBody Appointment appointment,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return null;

        appointment.setTenantId(tenantId);
        return repository.save(appointment);
    }

    @GetMapping
    public List<Appointment> list(
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return new ArrayList<>();

        return repository.findByTenantId(tenantId);
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable UUID id,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return;

        repository.deleteById(id);
    }
}