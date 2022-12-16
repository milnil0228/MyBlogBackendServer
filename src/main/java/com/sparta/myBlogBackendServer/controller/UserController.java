package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.SignupRequestDto;
import com.sparta.myBlogBackendServer.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
    }

}