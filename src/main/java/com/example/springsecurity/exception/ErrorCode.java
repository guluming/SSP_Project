package com.example.springsecurity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    SING_UP_DATA_VALID (400, "회원가입 양식을 확인해 주세요.", HttpStatus.BAD_REQUEST),
    USERNAME_OR_PASSWORD_NOTFOUND (400, "아이디 또는 비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED (401, "로그인 후 이용가능합니다.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(403, "해당 요청에 대한 권한이 없습니다.", HttpStatus.FORBIDDEN)
    ;

    @Getter
    private int code;

    @Getter
    private String message;

    @Getter
    private HttpStatus status;

    ErrorCode(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
