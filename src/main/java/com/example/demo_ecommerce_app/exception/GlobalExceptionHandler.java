package com.example.demo_ecommerce_app.exception;

import com.example.demo_ecommerce_app.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        CommonResponse commonResponse = new CommonResponse(500, e.getMessage(), null);
        return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
