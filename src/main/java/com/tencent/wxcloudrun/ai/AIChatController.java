package com.tencent.wxcloudrun.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
public class AIChatController {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String groupId = "1679642911832777";
    private static final String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJTdWJqZWN0SUQiOiIxNjc5NjQyOTExNDI0ODkwIiwiUGhvbmUiOiIxNzY2KioqMzk5MSIsIkdyb3VwSUQiOiIiLCJQYWdlTmFtZSI6IiIsImlzcyI6Im1pbmltYXgifQ.eOMveqhH-E8cvBiHg1Pj1uXSwERTNTkuxGofJU-1kTd28PEGjqwXui5qJnTPXfbLGMdPNcy4nZnw-mwPYwbTIAMWY88zaUxTIQ8pvu3TO8eZFaHwrjOhIgbAxF7Q35RvWyf5UGUWcSL7277xraWImk9CnInGAkb_KGvIBz5X7u-OHgO_LBIibkEiySFk6-PqLJlhU3Y46Zrc9cz_fkvgzT1lJWgiSuRTPBm_cfd1U7gpgM72UpGqstuJzsLjV19wLjnpcWoFUZ07Du_GTkJoWAek60sEq5onCZZHl0qnXlhsjPpm8JSUMcOK8K3p0yRL7HYdo_erlR7jDVYXHiM5xA";
    private static final String ai_url = String.format("https://api.minimax.chat//v1/text/chatcompletion?GroupId=%s", groupId);

    @PostMapping("ai-chat")
    public ResponseEntity<?> chat(@RequestBody List<Message> messages) throws JsonProcessingException {

        AIParam aiParam = new AIParam();
        aiParam.setMessages(messages);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonBody = mapper.writeValueAsString(aiParam);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        String response = restTemplate.postForObject(ai_url, requestEntity, String.class);
        return ResponseEntity.ok(response);
    }
}
