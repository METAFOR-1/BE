package com.example.hackathon.global.s3.exception;

import com.example.hackathon.global.exception.BaseErrorException;

public abstract class S3ErrorException {

    public static class S3UploadFailException extends BaseErrorException {
        public S3UploadFailException() {
            super(S3ErrorMessage.UPLOAD_FAIL.getErrorCode(), S3ErrorMessage.UPLOAD_FAIL.getMessage());
        }
    }

    public static class S3NotExistNameException extends BaseErrorException {
        public S3NotExistNameException() {
            super(S3ErrorMessage.NOT_EXIST_NAME.getErrorCode(), S3ErrorMessage.NOT_EXIST_NAME.getMessage());
        }
    }
}
