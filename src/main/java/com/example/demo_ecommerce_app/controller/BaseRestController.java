package com.example.demo_ecommerce_app.controller;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.service.SellDetailsService;
import com.example.demo_ecommerce_app.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
