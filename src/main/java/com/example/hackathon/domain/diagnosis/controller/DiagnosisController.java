package com.example.hackathon.domain.diagnosis.controller;

import com.example.hackathon.domain.chatGpt.service.ChatService;
import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseDiagnosisDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import com.example.hackathon.domain.diagnosis.service.DiagnosisService;
import com.example.hackathon.domain.youtube.dto.response.YoutubeResponseDto;
import com.example.hackathon.domain.youtube.service.YoutubeService;
import com.example.hackathon.global.s3.service.S3Service;
import java.io.IOException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    private final YoutubeService youtubeService;
    private final S3Service s3Service;
    private final ChatService chatService;

    @PostMapping("/diagnosis")
    public ResponseEntity<ResponseDiagnosisDto> diagnosis(@RequestBody RequestMentDto requestMentDto)
            throws IOException {

        ResponseModelDto diagnosis = diagnosisService.diagnosis(requestMentDto);
        YoutubeResponseDto youtubeResponseDto = youtubeService.searchVideo(diagnosis.muscleName());

        URL imageUrl = s3Service.getImageUrl(diagnosis.muscleName() + ".jpg");

        String chatgptAnswer = chatService.generateSummaryForKeyword(diagnosis.muscleName());

        ResponseDiagnosisDto responseDiagnosisDto = ResponseDiagnosisDto.of(diagnosis, youtubeResponseDto, imageUrl,
                chatgptAnswer);

        return ResponseEntity.ok(responseDiagnosisDto);
    }
}
