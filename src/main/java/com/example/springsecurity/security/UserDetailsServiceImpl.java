package com.example.springsecurity.security;

import com.example.springsecurity.entity.Member;
import com.example.springsecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String MemberId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(MemberId).orElseThrow(
                ()-> new UsernameNotFoundException("등록되지 않았거나 탈퇴한 사용자 입니다"));
        return new UserDetailsImpl(member);
    }
}
