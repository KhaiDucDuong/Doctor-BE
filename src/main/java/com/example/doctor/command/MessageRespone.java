package com.example.doctor.command;

public class MessageRespone {
    private String message;

    public MessageRespone(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}