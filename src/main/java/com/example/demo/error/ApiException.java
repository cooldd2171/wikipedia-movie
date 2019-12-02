package com.example.demo.error;

public class ApiException extends Exception {


    public ApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode.name();
        this.errorMessage=errorCode.getMessage();
    }
    public ApiException(String errorCode,String errorMessage){
        super(errorMessage);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorCode,errorMessage;



}
