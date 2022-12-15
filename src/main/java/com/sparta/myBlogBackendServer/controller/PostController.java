package com.sparta.myBlogBackendServer.controller;


import com.sparta.myBlogBackendServer.dto.PostDeleteDto;
import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import com.sparta.myBlogBackendServer.dto.PostResponseDto;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.update(id, postRequestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostDeleteDto postDeleteDto) {
        return postService.deletePost(id, postDeleteDto);
    }

}