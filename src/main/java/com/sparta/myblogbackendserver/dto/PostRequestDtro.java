package com.sparta.myblogbackendserver.dto;

import lombok.Getter;

@Getter
public class PostRequestDtro {
    private String username;
    private String password;
    private String title;
    private String contents;
}
