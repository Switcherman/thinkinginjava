package com.pctf.exception;

public class DBTableNotFoundException extends Exception {

    private String message;

    public DBTableNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
