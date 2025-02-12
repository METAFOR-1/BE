package com.example.hackathon.domain.diagnosis.service;

import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.request.RequestModelDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import com.example.hackathon.global.callapi.CallApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosisService {

    public ResponseModelDto diagnosis(RequestMentDto requestMentDto) {
        String trim = requestMentDto.ment().trim();
        return CallApiService.mentApi(new RequestModelDto(trim));
    }

}
