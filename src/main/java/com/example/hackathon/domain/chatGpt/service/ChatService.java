package com.example.hackathon.domain.chatGpt.service;

import com.example.hackathon.domain.chatGpt.dto.ChatGPTRequest;
import com.example.hackathon.domain.chatGpt.dto.ChatGPTResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final RestTemplate restTemplate;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getChatResponse(String prompt) {
        // GPT-3.5 또는 4 모델을 사용하여 질문을 전송
        ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo", prompt);
        ChatGPTResponse response = restTemplate.postForObject(OPENAI_API_URL, request, ChatGPTResponse.class);

        // GPT의 응답을 반환
        if (response != null && !response.getChoices().isEmpty()) {
            return response.getChoices().get(0).getMessage().getContent();
        }
        return "응답을 받을 수 없습니다.";
    }

    public String generateSummaryForKeyword(String keyword) {
        // 전달받은 키워드를 사용해 질문을 생성
        String question = String.format("%s 통증과 관련한 특징을 요약해줘. 환자 입장에서 이해가 되는 문장으로.", keyword);
        return getChatResponse(question);
    }
}
