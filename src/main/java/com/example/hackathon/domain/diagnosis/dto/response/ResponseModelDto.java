package com.example.hackathon.domain.diagnosis.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseModelDto(
        @JsonProperty("근육명_대분류") String muscleName
) {
}
