package com.example.hackathon.global.callapi;

import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.request.RequestModelDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
public class CallApiService {

    private final WebClient webClient;
    private static final String modelUrl  = "https://modelbpf-service-7565901301.us-central1.run.app/predict/";

    public CallApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public static ResponseModelDto mentApi(RequestModelDto requestMentDto) {

        WebClient webClient = WebClient.builder().build();

        return webClient
                .post()
                .uri(modelUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestMentDto)
                .retrieve()
                .bodyToMono(ResponseModelDto.class)
                .block();
    }
}
