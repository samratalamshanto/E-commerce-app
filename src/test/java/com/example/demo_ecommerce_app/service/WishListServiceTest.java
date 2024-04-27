package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.entity.WishListEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WishListServiceTest {
    @Autowired
    private WishListService wishListService;

    @Test
    void getCustomerWishListWhenCustomerNotExits() {
        assertThrows(RuntimeException.class, () -> wishListService.getCustomerWishList(2l));
    }

    @Test
    void getCustomerWishList() {
        CommonResponse response = wishListService.getCustomerWishList(1l);
        List<WishListEntity> list = (List<WishListEntity>) response.getData();
        assertEquals(1, list.size());
    }
}