package com.sparta.myblogbackendserver.controller;

import com.sparta.myblogbackendserver.dto.PostRequestDtro;
import com.sparta.myblogbackendserver.entity.Post;
import com.sparta.myblogbackendserver.repository.PostRepository;
import com.sparta.myblogbackendserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;  //컨트롤러는 서비스를 불러옴

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    //포스트 생성 화면
    @GetMapping("/posts/new")
    public ModelAndView savePost() {
        return new ModelAndView("savePost");
    }

    //포스트 읽기 화면
    @GetMapping("/post/read")
    public ModelAndView readPost() {
        return new ModelAndView("readPost");
    }


    @PostMapping("/api/post")   //Post 방식이기 때문에 @PostMapping
    public Post createPost(@RequestBody PostRequestDtro requestDtro) {
        return postService.createPost(requestDtro);
    }   //객체 형식으로 넘어오기 때문에 @RequestBody 사용, POST 방식이기 때문에 Body 존재

    @GetMapping("/api/post")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    //포스트 상세 조회하기
    @GetMapping("/api/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDtro requestDtro) {
        return postService.update(id, requestDtro);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
