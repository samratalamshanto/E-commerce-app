package com.example.demo_ecommerce_app.service;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import com.example.demo_ecommerce_app.enums.CommonStatusEnum;
import com.example.demo_ecommerce_app.exception.DateFormatException;
import com.example.demo_ecommerce_app.repository.SellDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.DateTimeException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellDetailsService {
    private final SellDetailsRepository sellDetailsRepository;

    public CommonResponse getTotalSaleAmount() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount", null);
        try {
            Double totalSell = sellDetailsRepository.getTotalSellAmountByDate(LocalDate.now(), CommonStatusEnum.Active.toString());
            if (ObjectUtils.isEmpty(totalSell)) {
                totalSell = 0.0;
            }
            commonResponse.setData(totalSell);
        } catch (Exception e) {
            log.error("SellDetailsService::getTotalSaleAmount() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("SellDetailsService::getTotalSaleAmount() Success, CommonResponse={}", commonResponse);
        return commonResponse;
    }

    public CommonResponse getTopFiveSellsProducts() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell amount", null);
        try {
            commonResponse.setData(sellDetailsRepository.getTopFiveSellProductsMappedWithObject());
        } catch (Exception e) {
            log.error("SellDetailsService::getTopFiveSellsProducts() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("SellDetailsService::getTotalSaleAmount() Success, CommonResponse={}", commonResponse);
        return commonResponse;
    }

    public CommonResponse getTopFiveSellsProductsOfLastMonthBasedOnTotalUnit() {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get total sell of last month based on total unit.", null);
        try {
            LocalDate today = LocalDate.now();
            LocalDate prevMonthDate = today.minusMonths(1);
            commonResponse.setData(sellDetailsRepository.getTopFiveSellProductsBasedOnNumberOfUnits(prevMonthDate));
            log.info("SellDetailsService::getTotalSaleAmount() Success, prevMonthDate={}, CommonResponse={}", prevMonthDate, commonResponse);
        } catch (Exception e) {
            log.error("SellDetailsService::getTopFiveSellsProductsOfLastMonthBasedOnTotalUnit() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }
        return commonResponse;
    }

    public CommonResponse getMaxSaleCertainDates(String fromDate, String toDate) {
        CommonResponse commonResponse = new CommonResponse(200, "Successfully get max sell date of certain dates.", null);
        try {
            if (validateDate(fromDate, toDate)) {
                commonResponse.setData(sellDetailsRepository.getMaxSaleDateCertainDates(fromDate, toDate));
                log.info("SellDetailsService::getMaxSaleCertainDates() Success, FromDate={} and ToDate={}, CommonResponse={}", fromDate, toDate commonResponse);
            }
        } catch (Exception e) {
            log.error("SellDetailsService::getMaxSaleCertainDates() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }

        return commonResponse;
    }

    private boolean validateDate(String startDate, String endDate) {
        boolean isDateValid = true;
        try {
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
        } catch (RuntimeException e) {
            log.error("SellDetailsService::validateDate() Error={}", e.getMessage());
            throw new RuntimeException(e);
        }
        return isDateValid;
    }
}
