package com.example.demo_ecommerce_app.exception;

public class DateFormatException extends RuntimeException {
    public DateFormatException() {
        super("Date was not proper format.yyyy-MM-dd format required.");
    }

    public DateFormatException(String errorMessage) {
        super(errorMessage);
    }
}
