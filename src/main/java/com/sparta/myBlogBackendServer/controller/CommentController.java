package com.sparta.myBlogBackendServer.controller;

import com.sparta.myBlogBackendServer.dto.CommentRequestDto;
import com.sparta.myBlogBackendServer.dto.CommentResponseDto;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.jwt.JwtUtil;
import com.sparta.myBlogBackendServer.repository.PostRepository;
import com.sparta.myBlogBackendServer.repository.UserRepository;
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
}
