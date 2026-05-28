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

    // ✅ CREATE SEGURO
    @PostMapping
    public Appointment create(
        @RequestBody Appointment appointment,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null || tenantId.equals("undefined")) {
            return null;
        }

        // ✅ GARANTE QUE NÃO VEM ID DO FRONTEND
        appointment.setId(null);

        // ✅ GARANTE MULTI-TENANT CORRETO
        appointment.setTenantId(tenantId);

        return repository.save(appointment);
    }

    // ✅ LIST SEGURO
    @GetMapping
    public List<Appointment> list(
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return new ArrayList<>();

        try {
            return repository.findByTenantId(tenantId);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ✅ HISTÓRICO (OK)
    @GetMapping("/client/{clientId}")
    public List<Appointment> byClient(
        @PathVariable UUID clientId
    ) {
        try {
            return repository.findByClientId(clientId);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ✅ DELETE COM VALIDAÇÃO DE TENANT (CRÍTICO)
    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable UUID id,
        @RequestHeader(value = "tenantId", required = false) String tenantId
    ) {
        if (tenantId == null) return;

        try {
            Optional<Appointment> apptOpt = repository.findById(id);

            if (apptOpt.isPresent()) {
                Appointment appt = apptOpt.get();

                // ✅ SÓ DELETA SE FOR DO MESMO TENANT
                if (tenantId.equals(appt.getTenantId())) {
                    repository.deleteById(id);
                }
            }

        } catch (Exception ignored) {
        }
    }
}