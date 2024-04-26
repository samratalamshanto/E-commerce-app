package com.example.demo_ecommerce_app.repository;

import com.example.demo_ecommerce_app.entity.SellDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDetailsRepository extends JpaRepository<SellDetailsEntity, Long> {
    @Query(value = "select sum(sellDetails.totalAmount) from SellDetailsEntity sellDetails " +
            " where cast(sellDetails.createdAtDt as date) = cast(:givenDate as date)" +
            " and sellDetails.status = :status")
    Double getTotalSellAmountByDate(String givenDate, String status);
}
