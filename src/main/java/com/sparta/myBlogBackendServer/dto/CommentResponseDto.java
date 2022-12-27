package com.sparta.myBlogBackendServer.dto;

import com.sparta.myBlogBackendServer.entity.Comment;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private long id;
    private String comment;
    private String username;
    private Long postId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public CommentResponseDto (Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.username = comment.getUser().getUsername();
        this.postId = comment.getPost().getId();
        this.createdDate = comment.getCreatedAt();
        this.modifiedDate = comment.getModifiedAt();
    }
}