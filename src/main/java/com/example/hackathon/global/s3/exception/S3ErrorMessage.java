package com.example.hackathon.global.s3.exception;

import lombok.Getter;

@Getter
public enum S3ErrorMessage {

    UPLOAD_FAIL(400, "사진 업로드에 실패하였습니다."),
    NOT_EXIST_NAME(404, "존재하지 않는 파일 이름입니다.");

    private final int errorCode;
    private final String message;

    S3ErrorMessage(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
