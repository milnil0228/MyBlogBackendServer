package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.LoginRequestDto;
import com.sparta.myBlogBackendServer.dto.SignupRequestDto;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public User signup (@RequestBody SignupRequestDto signupRequestDto) {
        User user = userService.signup(signupRequestDto);
        return user;
    }

    @PostMapping("/login")
    public void login (@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse reponse) {
        userService.login(loginRequestDto, reponse);
    }
}
