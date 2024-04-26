package com.example.demo_ecommerce_app.repository;

import com.example.demo_ecommerce_app.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity,Long> {
}