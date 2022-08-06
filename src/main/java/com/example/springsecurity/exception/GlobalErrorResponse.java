package com.example.springsecurity.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
public class GlobalErrorResponse {
        private Integer status;

        private LocalDateTime timestamp;

        private String message;

        private String path;

        @Builder
        public GlobalErrorResponse(Integer status, LocalDateTime timestamp, String message, String path) {
            this.status = status;
            this.timestamp = timestamp;
            this.message = message;
            this.path = path;
        }
}
