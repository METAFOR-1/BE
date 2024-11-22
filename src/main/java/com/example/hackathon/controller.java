package com.example.hackathon;

import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import com.example.hackathon.domain.youtube.service.YoutubeService;
import com.example.hackathon.global.s3.service.S3Service;
import java.io.IOException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class controller {

    private final S3Service s3Service;
    private final YoutubeService youtubeService;

    @PostMapping("/test")
    public ResponseModelDto test(@RequestBody RequestMentDto requestMentDto) {

        ResponseModelDto responseModelDto = new ResponseModelDto(requestMentDto.ment(), requestMentDto.ment());
        System.out.println("responseModelDto.muscleName() = " + responseModelDto.muscleName());

        return responseModelDto;
    }

    @GetMapping("/check")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("check");
    }
}
