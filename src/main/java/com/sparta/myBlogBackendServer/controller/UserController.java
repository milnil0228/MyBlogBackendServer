package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.LoginRequestDto;
import com.sparta.myBlogBackendServer.dto.SignupRequestDto;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup (@RequestBody @Valid SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return ResponseEntity.ok("로그인 완료");
    }
}
