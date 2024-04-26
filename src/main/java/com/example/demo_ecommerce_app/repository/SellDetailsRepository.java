package com.example.demo_ecommerce_app.repository;

import com.example.demo_ecommerce_app.entity.SellDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDetailsRepository extends JpaRepository<SellDetailsEntity,Long> {
}
