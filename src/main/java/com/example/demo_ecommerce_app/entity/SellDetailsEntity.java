package com.example.demo_ecommerce_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sell_details")
public class SellDetailsEntity extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String productName;
    private Long totalUnit;
    private Double unitPrice;
    private Double totalAmount;
    private Long customerId;
    private String customerName;
    private String status;
}
