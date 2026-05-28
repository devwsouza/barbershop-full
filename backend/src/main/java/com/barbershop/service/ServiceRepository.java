package com.barbershop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    List<Service> findByTenantId(String tenantId);
}