package com.example.springsecurity.controller;

import com.example.springsecurity.dto.Request.MemberSignupRequest;
import com.example.springsecurity.entity.MemberRoleEnum;
import com.example.springsecurity.security.UserDetailsImpl;
import com.example.springsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MemberService memberService;

    //로그인 페이지
    @GetMapping("/user/loginView")
    public String login() {
        return "login";
    }

    //회원가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    //회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(MemberSignupRequest memberSignupRequest) {
        memberService.memberSignup(memberSignupRequest);
        return "redirect:/user/loginView";
    }

    //메인 페이지
    @GetMapping("/")
    public String homePage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());

            if (userDetails.getUser().getRole() == MemberRoleEnum.ADMIN) {
                model.addAttribute("admin_role", true);
                return "indexAdmin";
            }
        }
        return "indexMember";
    }
}
