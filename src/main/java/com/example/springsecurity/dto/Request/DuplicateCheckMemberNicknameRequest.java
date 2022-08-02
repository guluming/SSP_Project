package com.example.springsecurity.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DuplicateCheckMemberNicknameRequest {
    private String nickname;
}
