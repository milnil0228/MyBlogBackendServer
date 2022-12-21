package com.sparta.myBlogBackendServer.controller;


import com.sparta.myBlogBackendServer.dto.PostDeleteDto;
import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import com.sparta.myBlogBackendServer.dto.PostResponseDto;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public PostRequestDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        return postService.createPost(postRequestDto, request);
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
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        postService.update(id, postRequestDto, request);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, HttpServletRequest request) {
        return postService.deletePost(id, request);
    }

}