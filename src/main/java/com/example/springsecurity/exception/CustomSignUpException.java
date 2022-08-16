package com.example.springsecurity.exception;

public class CustomSignUpException extends IllegalArgumentException {
    private final ErrorCode errorType;

    public CustomSignUpException(ErrorCode errorType) {
        this.errorType = errorType;
    }
}
