package com.sparta.myBlogBackendServer.dto;

import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String contents;
    private String title;
    private User user;
    private Post post;
}