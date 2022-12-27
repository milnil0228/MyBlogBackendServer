package com.sparta.myBlogBackendServer.dto;

import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String comment;
}
