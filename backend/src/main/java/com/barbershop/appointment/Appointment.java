package com.barbershop.appointment;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private UUID id;

    private String barberId;
    private String time;

    // ✅ ESSENCIAL PARA SAAS
    private String tenantId;

    // ✅ GETTERS E SETTERS

    public UUID getId() {
        return id;
    }

    public String getBarberId() {
        return barberId;
    }

    public void setBarberId(String barberId) {
        this.barberId = barberId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // ✅ NOVO (IMPORTANTE)
    public String getTenantId() {
        return tenantId;
    }

    // ✅ NOVO (IMPORTANTE)
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
