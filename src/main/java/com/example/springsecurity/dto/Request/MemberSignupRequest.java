package com.example.springsecurity.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupRequest {
    private String memberId;
    private String password;
    private String passwordchk;
    private String nickname;
}
