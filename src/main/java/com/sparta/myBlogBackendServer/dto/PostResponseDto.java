package com.sparta.myBlogBackendServer.dto;

import com.sparta.myBlogBackendServer.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponseDto {
    private String username;
    private String contents;
    private String title;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> comments;

    public PostResponseDto(Post post) {
        this.username = post.getUser().getUsername();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.comments = post.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
