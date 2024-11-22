package com.example.hackathon.domain.diagnosis.dto.response;

import com.example.hackathon.domain.youtube.dto.response.YoutubeResponseDto;
import java.net.URL;

public record ResponseDiagnosisDto(
        String muscleName,
        String youtubeTitle,
        URL youtubeLink,
        String reason,
        URL imageLink
) {
    public static ResponseDiagnosisDto of(ResponseModelDto responseModelDto, YoutubeResponseDto youtubeResponseDto, URL imageLink, String gtpAnswer) {
        return new ResponseDiagnosisDto(responseModelDto.muscleName(), youtubeResponseDto.title(), youtubeResponseDto.youtubeLink(), gtpAnswer, imageLink);
    }

    public static ResponseDiagnosisDto of2(String muscleName, YoutubeResponseDto youtubeResponseDto, URL imageLink, String gtpAnswer) {
        return new ResponseDiagnosisDto(muscleName, youtubeResponseDto.title(), youtubeResponseDto.youtubeLink(), gtpAnswer, imageLink);
    }
}
