package com.tencent.wxcloudrun.ai;

import lombok.Data;


public class Message {
    private String sender_type = "";
    private String text = "";

    public Message() {
    }

    public Message(String sender_type, String text) {
        this.sender_type = sender_type;
        this.text = text;
    }

    public String getSender_type() {
        return sender_type;
    }

    public void setSender_type(String sender_type) {
        this.sender_type = sender_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
