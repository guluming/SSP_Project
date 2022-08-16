package com.example.springsecurity.service;

import com.example.springsecurity.dto.Request.DuplicateCheckMemberIdRequest;
import com.example.springsecurity.dto.Request.DuplicateCheckMemberNicknameRequest;
import com.example.springsecurity.dto.Request.MemberLoginRequest;
import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.entity.Member;
import com.example.springsecurity.entity.MemberRoleEnum;
import com.example.springsecurity.exception.ErrorCode;
import com.example.springsecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    //회원가입
    public ResponseEntity<?> memberSignup(MemberSignupRequest memberSignupRequest) {
        Optional<Member> memberIdCheck = memberRepository.findByMemberId(memberSignupRequest.getMemberId());
        if (memberIdCheck.isPresent()) {
            return new ResponseEntity<>("중복된 아이디입니다.", HttpStatus.BAD_REQUEST);
        } else {
            if (!memberSignupRequest.getPassword().equals(memberSignupRequest.getPasswordchk())) {
                return new ResponseEntity<>("재확인 비밀번호가 다릅니다.", HttpStatus.BAD_REQUEST);
            } else {
                MemberRoleEnum role = MemberRoleEnum.USER;

                Member newMember = new Member(memberSignupRequest, role);
                newMember.encryptPassword(passwordEncoder);
                memberRepository.save(newMember);

                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
    }

    //ID 중복 검사
    public ResponseEntity<?> duplicateCheckMemberId(DuplicateCheckMemberIdRequest duplicateCheckMemberIdRequest) {
        Optional<Member> memberIdCheck = memberRepository.findByMemberId(duplicateCheckMemberIdRequest.getMemberId());
        if (duplicateCheckMemberIdRequest.getMemberId() == null) {
            return new ResponseEntity<>("아이디를 입력해 주세요.", HttpStatus.BAD_REQUEST);
        } else if (duplicateCheckMemberIdRequest.getMemberId().trim().equals("")) {
            return new ResponseEntity<>("아이디를 입력해 주세요.", HttpStatus.BAD_REQUEST);
        } else if (memberIdCheck.isPresent()) {
            return new ResponseEntity<>("중복된 아이디 입니다.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //닉네임 중복 검사
    public ResponseEntity<?> duplicateCheckMemberNickname(DuplicateCheckMemberNicknameRequest duplicateCheckMemberNicknameRequest) {
        Optional<Member> memberNicknameCheck = memberRepository.findByNickname(duplicateCheckMemberNicknameRequest.getNickname());
        if (duplicateCheckMemberNicknameRequest.getNickname() == null) {
            return new ResponseEntity<>("닉네임을 입력해 주세요.", HttpStatus.BAD_REQUEST);
        } else if (duplicateCheckMemberNicknameRequest.getNickname().trim().equals("")) {
            return new ResponseEntity<>("닉네임을 입력해 주세요.", HttpStatus.BAD_REQUEST);
        } else if (duplicateCheckMemberNicknameRequest.getNickname().matches("^[가-힣a-zA-Z]+$")) {
            return new ResponseEntity<>("닉네임 형식을 확인해 주세요.", HttpStatus.BAD_REQUEST);
        } else if (memberNicknameCheck.isPresent()) {
            return new ResponseEntity<>("중복된 닉네임 입니다.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //로그인
    public ResponseEntity<?> memberLogin(MemberLoginRequest memberLoginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(memberLoginRequest.getMemberId(), memberLoginRequest.getPassword()));
        } catch (Exception e) {
            return new ResponseEntity<>(ErrorCode.USERNAME_OR_PASSWORD_NOTFOUND.getMessage(), ErrorCode.USERNAME_OR_PASSWORD_NOTFOUND.getStatus());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
