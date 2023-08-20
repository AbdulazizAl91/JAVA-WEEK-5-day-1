package com.example.schoolmanagemen.Api;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
