package com.example.demo_ecommerce_app.controller;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.service.SellDetailsService;
import com.example.demo_ecommerce_app.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/rest")
@RequiredArgsConstructor
public class BaseRestController {
    private final WishListService wishListService;
    private final SellDetailsService sellDetailsService;

    @GetMapping("/get-wish-list")
    public CommonResponse getCustomerWishList(@RequestParam("customerId") Long customerId) {
        return wishListService.getCustomerWishList(customerId);
    }

    @GetMapping("/get-total-sales-amount")
    public CommonResponse getTotalSaleAmount() {
        return sellDetailsService.getTotalSaleAmount();
    }

    @GetMapping("/get-top-five-sells-product")
    public CommonResponse getTopFiveSellsProducts() {
        return sellDetailsService.getTopFiveSellsProducts();
    }

    @GetMapping("/get-last-month-top-five-sells-product-based-on-unit")
    public CommonResponse getLastMonthTopFiveSellsProductsBasedOnUnit() {
        return sellDetailsService.getTopFiveSellsProductsOfLastMonthBasedOnTotalUnit();
    }

    @GetMapping("/get-max-sale-certain-time-range")
    public CommonResponse getMaxSaleCertainDates(@RequestParam("fromDate") LocalDate startDate, @RequestParam("toDate") LocalDate endDate) {
        return sellDetailsService.getMaxSaleCertainDates(startDate, endDate);
    }
}
