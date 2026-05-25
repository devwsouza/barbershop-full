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
        @RequestHeader("tenantId") String tenantId
    ) {
        appointment.setTenantId(tenantId);
        return repository.save(appointment);
    }

    @GetMapping
    public List<Appointment> list(
        @RequestHeader("tenantId") String tenantId
    ) {
        return repository.findByTenantId(tenantId);
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable UUID id,
        @RequestHeader("tenantId") String tenantId
    ) {
        repository.deleteById(id);
    }
}
``