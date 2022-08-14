package com.example.springsecurity.validator;

import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.exception.CustomSignUpException;
import com.example.springsecurity.exception.ErrorCode;

public class MemberValidator {
    public static void validatrMemberRegist(MemberSignupRequest singUpData) {
        try {
            //ID 검사
            if(singUpData.getMemberId() == null){
                throw new IllegalArgumentException("아이디를 입력해 주세요");
            }
            if (singUpData.getMemberId().equals("")) {
                throw new IllegalArgumentException("아이디를 입력해 주세요");
            }

            //닉네임 검사
            if(singUpData.getNickname() == null){
                throw new IllegalArgumentException("닉네임을 입력해 주세요");
            }
            if (singUpData.getNickname().equals("")) {
                throw new IllegalArgumentException("닉네임을 입력해 주세요");
            }
            if (!singUpData.getNickname().matches("^[가-힣a-zA-Z]+$")) {
                throw new IllegalArgumentException("닉네임 형식을 확인해 주세요");
            }

            //비밀번호 검사
            if(singUpData.getPassword() == null){
                throw new IllegalArgumentException("비밀번호를 입력해 주세요");
            }
            if (singUpData.getPassword().equals("")) {
                throw new IllegalArgumentException("비밀번호를 입력해 주세요");
            }
        } catch (Exception e) {
            throw new CustomSignUpException(ErrorCode.SING_UP_DATA_VALID);
        }
    }
}
