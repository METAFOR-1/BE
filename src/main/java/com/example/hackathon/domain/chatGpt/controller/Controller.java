package com.example.hackathon.domain.chatGpt.controller;

import com.example.hackathon.domain.chatGpt.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ChatService chatService;

    @GetMapping("/api/v1/chat-gpt")
    public String generateSummary(@RequestParam String keyword) {
        // 키워드로 요약 요청을 보냅니다.
        return chatService.generateSummaryForKeyword(keyword);
    }
}
