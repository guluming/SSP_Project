package com.example.springsecurity.controller;

import com.example.springsecurity.dto.Request.DuplicateCheckMemberIdRequest;
import com.example.springsecurity.dto.Request.DuplicateCheckMemberNicknameRequest;
import com.example.springsecurity.dto.Request.MemberLoginRequest;
import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/api/member/signup")
    public ResponseEntity<?> memberSignup(@RequestBody MemberSignupRequest memberSignupRequest) {
        return memberService.memberSignup(memberSignupRequest);
    }

    //ID 중복 검사
    @PostMapping("/api/member/id/check")
    public ResponseEntity<?> duplicateCheckMemberId(@RequestBody DuplicateCheckMemberIdRequest duplicateCheckMemberIdRequest) {
        return memberService.duplicateCheckMemberId(duplicateCheckMemberIdRequest);
    }

    //닉네임 중복 검사
    @PostMapping("/api/member/nickname/check")
    public ResponseEntity<?> duplicateCheckMemberNickname(@RequestBody DuplicateCheckMemberNicknameRequest duplicateCheckMemberNicknameRequest) {
        return memberService.duplicateCheckMemberNickname(duplicateCheckMemberNicknameRequest);
    }

    //로그인
    @PostMapping("/api/member/login")
    public ResponseEntity<?> memberLogin(@RequestBody MemberLoginRequest memberLoginRequest) {
        return memberService.memberLogin(memberLoginRequest);
    }
}
