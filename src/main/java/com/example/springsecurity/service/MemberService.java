package com.example.springsecurity.service;

import com.example.springsecurity.dto.Request.DuplicateCheckMemberIdRequest;
import com.example.springsecurity.dto.Request.DuplicateCheckMemberNicknameRequest;
import com.example.springsecurity.dto.Request.MemberLoginRequest;
import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    public ResponseEntity<?> memberSignup(MemberSignupRequest memberSignupRequest) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //ID 중복 검사
    public ResponseEntity<?> duplicateCheckMemberId(DuplicateCheckMemberIdRequest duplicateCheckMemberIdRequest) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //닉네임 중복 검사
    public ResponseEntity<?> duplicateCheckMemberNickname(DuplicateCheckMemberNicknameRequest duplicateCheckMemberNicknameRequest) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //로그인
    public ResponseEntity<?> memberLogin(MemberLoginRequest memberLoginRequest) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
