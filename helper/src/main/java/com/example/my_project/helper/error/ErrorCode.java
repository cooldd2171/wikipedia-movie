package com.example.my_project.helper.error;

public enum  ErrorCode {

    USER_NOT_FOUND("com.example.my_project.User not found");
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private String message;


}
