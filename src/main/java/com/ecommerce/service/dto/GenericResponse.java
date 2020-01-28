package com.ecommerce.service.dto;

public class GenericResponse {

    private Boolean error;
    private String errorMessage;

    public GenericResponse() {
        this.error = false;
    }

    public GenericResponse(String errorMessage) {
        this.error = true;
        this.errorMessage = errorMessage;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
