package com.example.springsecurity.security;

import com.example.springsecurity.entity.Member;
import com.example.springsecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String MemberId) throws UsernameNotFoundException {
        Optional<Member> findMember = memberRepository.findByMemberId(MemberId);
        if (!findMember.isPresent()) {
            throw new UsernameNotFoundException("존재하지 않는 사용자 입니다.");
        }
        return new UserDetailsImpl(findMember.get().getMemberId(), findMember.get().getPassword() ,findMember.get().getRole());
    }
}
