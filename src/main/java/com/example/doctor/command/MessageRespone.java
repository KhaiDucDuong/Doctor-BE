package com.example.doctor.command;

import org.bson.types.ObjectId;

public class MessageRespone {
    private String message;

    public MessageRespone(String message) {
        this.message = message;
    }

    public MessageRespone(ObjectId attribute) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
