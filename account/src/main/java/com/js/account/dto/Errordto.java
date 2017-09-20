package com.js.account.dto;

public class Errordto {

    private String message;

    public Errordto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
