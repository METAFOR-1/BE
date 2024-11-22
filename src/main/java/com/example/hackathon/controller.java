package com.example.hackathon;

import com.example.hackathon.domain.diagnosis.dto.request.RequestMentDto;
import com.example.hackathon.domain.diagnosis.dto.response.ResponseModelDto;
import com.example.hackathon.global.s3.service.S3Service;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class controller {

    private final S3Service s3Service;

    @PostMapping("/test")
    public ResponseModelDto test(@RequestBody RequestMentDto requestMentDto) {

        ResponseModelDto responseModelDto = new ResponseModelDto(requestMentDto.ment(), requestMentDto.ment());
        System.out.println("responseModelDto.muscleName() = " + responseModelDto.muscleName());

        return responseModelDto;
    }

    @GetMapping("/url")
    public URL url() {
        return s3Service.getImageUrl("승모근.jpg");
    }
}
