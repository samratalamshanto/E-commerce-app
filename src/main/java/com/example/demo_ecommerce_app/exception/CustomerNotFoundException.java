package com.example.demo_ecommerce_app.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer Not Exits.");
    }
}
