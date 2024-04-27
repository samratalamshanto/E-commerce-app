package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.repository.SellDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SellDetailsService {
    private final SellDetailsRepository sellDetailsRepository;

    public CommonResponse getTotalSaleAmount() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount", null);
        try {
            Double totalSell = sellDetailsRepository.getTotalSellAmountByDate(LocalDate.now().toString(), CommonStatusEnum.Active.toString());
            commonResponse.setData(totalSell);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }


    public CommonResponse getTopFiveSellsProducts() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount", null);
        try {
            commonResponse.setData(sellDetailsRepository.getTopFiveSellProductsMappedWithObject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }

    public CommonResponse getTopFiveSellsProductsOfLastMonthBasedOnTotalUnit() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount of last month.", null);
        try {
            LocalDate today = LocalDate.now();
            LocalDate prevMonthDate = today.minusMonths(1);
            commonResponse.setData(sellDetailsRepository.getTopFiveSellProductsBasedOnNumberOfUnits(prevMonthDate));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }
}
