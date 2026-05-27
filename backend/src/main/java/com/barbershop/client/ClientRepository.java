package com.barbershop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findByTenantId(String tenantId);
}