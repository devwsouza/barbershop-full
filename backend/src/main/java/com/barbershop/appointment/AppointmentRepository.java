package com.barbershop.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    List<Appointment> findByTenantId(String tenantId);
    List<Appointment> findByClientId(UUID clientId);
}
