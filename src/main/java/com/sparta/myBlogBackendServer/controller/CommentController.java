package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.CommentRequestDto;
import com.sparta.myBlogBackendServer.jwt.JwtUtil;
import com.sparta.myBlogBackendServer.service.CommentService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final JwtUtil jwtUtil;

    @PostMapping("/api/posts/{id}/comment")
    public ResponseEntity createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        /*토큰 확인*/
        if (token != null) {
            claims = jwtUtil.getUserInformationFromToken(token);

            commentService.createComment(id, commentRequestDto, claims);
        } else {
            throw new IllegalArgumentException("Token Error");
        }
        return ResponseEntity.ok("댓글 작성 완료");
    }

    @PutMapping("/api/comment/{commentId}")
    public ResponseEntity updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        /*토큰 확인*/
        if (token != null) {
            claims = jwtUtil.getUserInformationFromToken(token);

            commentService.updateComment(commentId, commentRequestDto);
        } else {
            throw new IllegalArgumentException("Token Error");
        }
        return ResponseEntity.ok("댓글 작성 완료");
    }

    @DeleteMapping("/api/comment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if (token != null) {
            claims = jwtUtil.getUserInformationFromToken(token);

            commentService.deleteComment(commentId);
        } else {
            throw new IllegalArgumentException("Token error");
        }
        return ResponseEntity.ok("댓글 삭제 완료");
    }
}
