package com.example.demo_ecommerce_app.repository;

import com.example.demo_ecommerce_app.dto.sell_details.TopFiveProductsDto;
import com.example.demo_ecommerce_app.entity.SellDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellDetailsRepository extends JpaRepository<SellDetailsEntity, Long> {
    @Query(value = "select sum(sellDetails.totalAmount) from SellDetailsEntity sellDetails " +
            " where cast(sellDetails.createdAtDt as date) = cast(:givenDate as date)" +
            " and sellDetails.status = :status")
    Double getTotalSellAmountByDate(String givenDate, String status);

    @Query(value = "select new com.example.demo_ecommerce_app.dto.sell_details" +
            ".TopFiveProductsDto(sellDetails.productName, sum(sellDetails.totalAmount), sum(sellDetails.totalUnit)) " +
            "  from SellDetailsEntity as sellDetails" +
            "  where sellDetails.status ='Active' group by sellDetails.productName " +
            "  order by sum(sellDetails.totalAmount) desc fetch first 5 rows only")
    List<TopFiveProductsDto> getTopFiveSellProductsMappedWithObject();


    @Query(value = "select new com.example.demo_ecommerce_app.dto.sell_details" +
            ".TopFiveProductsDto(sellDetails.productName, sum(sellDetails.totalAmount), sum(sellDetails.totalUnit)) " +
            "  from SellDetailsEntity as sellDetails" +
            "  where sellDetails.status ='Active' " +
            "  and date_trunc('month', sellDetails.createdAtDt) = date_trunc('month', cast(:prevMonthDate as date))" +
            "  group by sellDetails.productName " +
            "  order by sum(sellDetails.totalUnit) desc fetch first 5 rows only")
    List<TopFiveProductsDto> getTopFiveSellProductsBasedOnNumberOfUnits(LocalDate prevMonthDate);

    @Query(value = "select cast(sellDetails.createdAtDt as date) as date" +
            "  from SellDetailsEntity as sellDetails" +
            "  where sellDetails.status ='Active' " +
            "  and to_char(sellDetails.createdAtDt, 'YYYY-MM-dd') " +
            "  between to_char(cast(:startDate as date) , 'YYYY-MM-dd') and to_char(cast(:endDate as date), 'YYYY-MM-dd')" +
            "  group by date " +
            "  order by sum(sellDetails.totalAmount) desc fetch first 1 rows only")
    List<?> getMaxSaleDateCertainDates(String startDate, String endDate);

}
