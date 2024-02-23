package com.zara.product.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public NotFoundException( String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public NotFoundException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}