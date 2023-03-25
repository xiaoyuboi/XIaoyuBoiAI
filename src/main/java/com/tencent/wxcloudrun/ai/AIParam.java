package com.tencent.wxcloudrun.ai;

import lombok.Data;

import java.util.List;

public class AIParam {
    private String model = "abab5-chat";
    private Integer tokens_to_generate = 512;
    private List<Message> messages;

    public AIParam() {
    }

    public AIParam(String model, Integer tokens_to_generate, List<Message> messages) {
        this.model = model;
        this.tokens_to_generate = tokens_to_generate;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTokens_to_generate() {
        return tokens_to_generate;
    }

    public void setTokens_to_generate(Integer tokens_to_generate) {
        this.tokens_to_generate = tokens_to_generate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
