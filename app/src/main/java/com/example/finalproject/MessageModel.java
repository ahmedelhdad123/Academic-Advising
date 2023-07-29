package com.example.finalproject;

public class MessageModel {
    private String msgId;
    private String senderName;
    private String message;

    public MessageModel( String senderName, String message) {


        this.senderName = senderName;
        this.message = message;
    }


    public MessageModel() {
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getsenderName() {
        return senderName;
    }

    public void setsenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
