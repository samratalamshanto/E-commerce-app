package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.entity.WishListEntity;
import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;

    public CommonResponse getCustomerWishList(Long customerId) {
        CommonResponse commonResponse = new CommonResponse(200, "Get wish list data successfully", null);
        try {
            List<WishListEntity> wishList = wishListRepository.findAllByCustomerIdAndStatus(customerId, CommonStatusEnum.Active.toString());
            commonResponse.setData(wishList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }
}
