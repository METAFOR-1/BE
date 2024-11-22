package com.example.hackathon.domain.diagnosis.controller;

import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import com.example.hackathon.domain.diagnosis.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @PostMapping("/diagnosis")
    public ResponseEntity<ResponseModelDto> diagnosis(@RequestBody RequestMentDto requestMentDto) {

        ResponseModelDto diagnosis = diagnosisService.diagnosis(requestMentDto);
        return ResponseEntity.ok(diagnosis);
    }
}
