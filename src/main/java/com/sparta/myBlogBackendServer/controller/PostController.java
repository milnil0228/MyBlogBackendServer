package com.sparta.myBlogBackendServer.controller;


import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import com.sparta.myBlogBackendServer.dto.PostResponseDto;
import com.sparta.myBlogBackendServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public ResponseEntity createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        postService.createPost(postRequestDto, request);
        return ResponseEntity.ok("게시글 작성 완료");
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/api/posts/{id}")
    public ResponseEntity updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        postService.update(id, postRequestDto, request);
        return ResponseEntity.ok("게시글 수정 완료");
    }

    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity deletePost(@PathVariable Long id, HttpServletRequest request) {
        postService.deletePost(id, request);
        return ResponseEntity.ok("게시글 삭제 완료");
    }

}