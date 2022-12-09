package com.sparta.MyBlogBackendServer.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
}