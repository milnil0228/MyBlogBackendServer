package com.sparta.myBlogBackendServer.dto;

import com.sparta.myBlogBackendServer.entity.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String contents;
    private String title;
}