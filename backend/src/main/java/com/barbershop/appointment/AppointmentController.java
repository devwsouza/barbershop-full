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
        if (tenantId == null || tenantId.equals("undefined")) {
            return null;
        }

        appointment.setTenantId(tenantId);
        return repository.save(appointment);
    }

    @GetMapping
    public List<Appointment> list(
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null || tenantId.equals("undefined")) {
            return new ArrayList<>();
        }

        try {
            return repository.findByTenantId(tenantId);
        } catch (Exception e) {
            return new ArrayList<>(); // ✅ evita erro 500
        }
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable UUID id,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null || tenantId.equals("undefined")) {
            return;
        }

        try {
            repository.deleteById(id);
        } catch (Exception ignored) {
            // ✅ evita erro 500
        }
    }
}