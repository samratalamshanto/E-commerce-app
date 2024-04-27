package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.exception.DateFormatException;
import com.example.demo_ecommerce_app.repository.SellDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SellDetailsService {
    private final SellDetailsRepository sellDetailsRepository;

    public CommonResponse getTotalSaleAmount() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount", null);
        try {
            Double totalSell = sellDetailsRepository.getTotalSellAmountByDate(LocalDate.now(), CommonStatusEnum.Active.toString());
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
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell of last month based on total unit.", null);
        try {
            LocalDate today = LocalDate.now();
            LocalDate prevMonthDate = today.minusMonths(1);
            commonResponse.setData(sellDetailsRepository.getTopFiveSellProductsBasedOnNumberOfUnits(prevMonthDate));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }

    public CommonResponse getMaxSaleCertainDates(String fromDate, String toDate) {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get max sell date of certain dates.", null);
        try {
            if (validateDate(fromDate, toDate)) {
                commonResponse.setData(sellDetailsRepository.getMaxSaleDateCertainDates(fromDate, toDate));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commonResponse;
    }

    private boolean validateDate(String startDate, String endDate) {
        boolean isDateValid = true;
        LocalDate fromDate;
        LocalDate toDate;
        try {
            fromDate = LocalDate.parse(startDate);
            toDate = LocalDate.parse(endDate);
        } catch (DateTimeException e) {
            throw new DateFormatException();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        if (!fromDate.isEqual(toDate) && fromDate.isAfter(toDate)) {
            throw new DateFormatException("ToDate occurs before FromDate");
        }
        return isDateValid;
    }
}
