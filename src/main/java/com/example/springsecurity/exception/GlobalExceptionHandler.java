package com.example.springsecurity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseBody
//    public ResponseEntity<GlobalErrorResponse> handleAuthenticationException(AuthenticationException ex){
//        GlobalErrorResponse errorResponse = new GlobalErrorResponse
//                (ErrorCode.USERNAME_OR_PASSWORD_NOTFOUND.getCode(),
//                        ErrorCode.USERNAME_OR_PASSWORD_NOTFOUND.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public GlobalErrorResponse handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        log.error("error", e);

        return GlobalErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
    }
}
