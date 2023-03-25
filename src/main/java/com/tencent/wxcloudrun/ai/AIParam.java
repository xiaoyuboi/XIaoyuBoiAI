package com.tencent.wxcloudrun.ai;

import lombok.Data;

import java.util.List;

@Data
public class AIParam {
    private String model = "abab5-chat";
    private Integer tokens_to_generate = 512;
    private List<Message> messages;
}
