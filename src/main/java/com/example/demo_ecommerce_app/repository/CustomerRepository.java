package com.example.demo_ecommerce_app.repository;

import com.example.demo_ecommerce_app.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByIdAndStatus(Long customerId, String status);
}
