package com.barbershop.client;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String phone;

    @Column(name = "tenant_id")
    private String tenantId;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}