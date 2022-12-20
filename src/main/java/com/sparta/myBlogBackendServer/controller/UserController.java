package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.LoginRequestDto;
import com.sparta.myBlogBackendServer.dto.SignupRequestDto;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup (@RequestBody @Valid SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "회원가입을 축하합니다!";
    }

    @PostMapping("/login")
    public String login (@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "로그인을 완료하였습니다!";
    }
}
