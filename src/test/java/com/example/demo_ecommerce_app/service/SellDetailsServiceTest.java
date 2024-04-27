package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.repository.SellDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SellDetailsServiceTest {
    @Autowired
    private SellDetailsRepository sellDetailsRepository;

    @Test
    void getTotalSaleAmount() {
        assertEquals("1200.0", sellDetailsRepository.getTotalSellAmountByDate(LocalDate.parse("2024-04-27"), CommonStatusEnum.Active.toString()).toString());
    }

    @Test
    void getTopFiveSellsProducts() {
        assertEquals("Keyboard", sellDetailsRepository.getTopFiveSellProductsMappedWithObject().get(0).getProductName());
    }

    @Test
    void getTopFiveSellsProductsOfLastMonthBasedOnTotalUnit() {
        assertEquals("Mouse", sellDetailsRepository.getTopFiveSellProductsBasedOnNumberOfUnits(LocalDate.parse("2024-04-27")).get(0).getProductName());
    }

    @Test
    void getMaxSaleCertainDates() {
        assertEquals("2024-04-27", sellDetailsRepository.getMaxSaleDateCertainDates("2024-04-01", "2024-04-30").get(0).toString());
    }
}