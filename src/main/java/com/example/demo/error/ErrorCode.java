package com.example.demo.error;

public enum  ErrorCode {

    USER_NOT_FOUND("User not found"),
    EMAIL_EXISTS("Please Enter Unique Email");





    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private String message;


}
