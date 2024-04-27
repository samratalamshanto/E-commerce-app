package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.entity.CustomerEntity;
import com.example.demo_ecommerce_app.entity.WishListEntity;
import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.exception.CustomerNotFoundException;
import com.example.demo_ecommerce_app.repository.CustomerRepository;
import com.example.demo_ecommerce_app.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo_ecommerce_app.util.Utility.ObjectToJson;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishListService {
    private final WishListRepository wishListRepository;
    private final CustomerRepository customerRepository;

    public CommonResponse getCustomerWishList(Long customerId) {
        CommonResponse commonResponse = new CommonResponse(200, "Get wish list data successfully", null);
        try {
            List<WishListEntity> wishList = wishListRepository.findAllByCustomerIdAndStatus(customerId, CommonStatusEnum.Active.toString());
            if (wishList.isEmpty()) {
                checkCustomer(customerId);
            }
            commonResponse.setData(wishList);
            log.info("WishListService::getCustomerWishList() CustomerID={}, CommonResponse={}", customerId, ObjectToJson(commonResponse));
        } catch (Exception e) {
            log.error("WishListService::getCustomerWishList() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }
        return commonResponse;
    }

    private void checkCustomer(Long customerId) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByIdAndStatus(customerId, CommonStatusEnum.Active.toString());
        log.info("WishListService::checkCustomer() CustomerID={}, CustomerEntity={}", customerId, customerEntity);
        if (!customerEntity.isPresent()) {
            throw new CustomerNotFoundException();
        }
    }
}
