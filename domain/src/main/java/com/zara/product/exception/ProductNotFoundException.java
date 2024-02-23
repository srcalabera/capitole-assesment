package com.zara.product.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public ProductNotFoundException(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public ProductNotFoundException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}