package com.barbershop.service;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}