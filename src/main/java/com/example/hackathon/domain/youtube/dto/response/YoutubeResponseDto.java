package com.example.hackathon.domain.youtube.dto.response;

import java.net.URL;

public record YoutubeResponseDto(
        String title,
        URL youtubeLink
) {
}
