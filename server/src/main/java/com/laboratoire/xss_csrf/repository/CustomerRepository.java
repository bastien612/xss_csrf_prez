package com.laboratoire.xss_csrf.repository;

import com.laboratoire.xss_csrf.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {
    @Override
    CustomerModel getOne(UUID uuid);

    CustomerModel findByLogin(String login);
}
