package com.urlshortener.demo.exception;


import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Apiexception {

    private int status;

    private String message;

    private String path;

    private Map<String,String> validateexception;
    public Apiexception(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;

    }
}
