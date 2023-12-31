package com.example.finalproject;
import java.io.Serializable;

public class ChatMessage implements Serializable{
    private String message;
    private String reciever;
    private String sender;

    public ChatMessage(String message, String reciever, String sender) {
        this.message = message;
        this.reciever = reciever;
        this.sender = sender;
    }

    public ChatMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
