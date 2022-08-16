package com.example.springsecurity.entity;

import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.validator.MemberValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MemberRoleEnum role;

    public Member(MemberSignupRequest param, MemberRoleEnum role) {

        MemberValidator.validatorMemberId(param.getMemberId());
        MemberValidator.validatorNickname(param.getNickname());
        MemberValidator.validatorPassword(param.getPassword(), param.getPasswordchk());

        this.memberId = param.getMemberId();
        this.password = param.getPassword();
        this.nickname = param.getPassword();
        this.role = role;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }
}
