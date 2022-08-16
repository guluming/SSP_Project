package com.example.springsecurity.validator;

import com.example.springsecurity.exception.CustomSignUpException;
import com.example.springsecurity.exception.ErrorCode;

public class MemberValidator {
    public static void validatorMemberId(String checkMemberIdRequest) {
        try {
            //ID 검사
            if (checkMemberIdRequest == null) {
                throw new IllegalArgumentException("아이디를 입력해 주세요");
            }
            if (checkMemberIdRequest.trim().equals("")) {
                throw new IllegalArgumentException("아이디를 입력해 주세요");
            }
        } catch (Exception e) {
            throw new CustomSignUpException(ErrorCode.SING_UP_DATA_VALID);
        }
    }

    public static void validatorNickname(String checkMemberNicknameRequest) {
        try {
            //닉네임 검사
            if (checkMemberNicknameRequest == null) {
                throw new IllegalArgumentException("닉네임을 입력해 주세요");
            }
            if (checkMemberNicknameRequest.trim().equals("")) {
                throw new IllegalArgumentException("닉네임을 입력해 주세요");
            }
            if (!checkMemberNicknameRequest.matches("^[가-힣a-zA-Z]+$")) {
                throw new IllegalArgumentException("닉네임 형식을 확인해 주세요");
            }
        } catch (Exception e) {
            throw new CustomSignUpException(ErrorCode.SING_UP_DATA_VALID);
        }
    }

    public static void validatorPassword(String password, String passwordchk) {
        try {
            //비밀번호 검사
            if (password == null) {
                throw new IllegalArgumentException("비밀번호를 입력해 주세요");
            }
            if (password.trim().equals("")) {
                throw new IllegalArgumentException("비밀번호를 입력해 주세요");
            }
            if (password.equals(passwordchk)) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
            }
        } catch (Exception e) {
            throw new CustomSignUpException(ErrorCode.SING_UP_DATA_VALID);
        }
    }
}
