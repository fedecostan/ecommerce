package com.ecommerce.service.dto;

public enum ErrorEnum {

    GENERIC_ERROR("GENERIC_ERROR");

    private String errorMessage;

    ErrorEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
