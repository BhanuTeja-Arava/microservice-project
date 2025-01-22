package com.microservice.product_service.exception;

public class ErroMsg {
    String errorMessage;
    String reason;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ErroMsg(String errorMessage, String reason) {
        this.errorMessage = errorMessage;
        this.reason = reason;
    }
}
