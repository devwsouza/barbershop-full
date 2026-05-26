package com.barbershop.user;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users") // ✅ IMPORTANTE
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String password;

    @Column(name = "tenant_id") // ✅ MAPEAMENTO CORRETO
    private String tenantId;

    public UUID getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
}