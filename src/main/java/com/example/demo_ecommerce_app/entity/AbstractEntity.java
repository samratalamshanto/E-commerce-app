package com.example.demo_ecommerce_app.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AbstractEntity {
    private Timestamp createdAtDt;
    private Long createdBy;
    private String createdByUserName;
    private Timestamp updatedAtDt;
    private Long updatedBy;
    private String updatedByUserName;
    private Timestamp deletedAtDt;
    private Long deletedBy;
    private String deletedByUserName;
}
