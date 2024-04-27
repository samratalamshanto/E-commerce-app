package com.example.demo_ecommerce_app.dto.sell_details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopFiveProductsDto {
    private String productName;
    private double totalSellAmount;
    private Long totalUnit;
}
