package com.shourya.demo.helper.error;

public enum  ErrorCode {

    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User Already Exists");
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private String message;


}
