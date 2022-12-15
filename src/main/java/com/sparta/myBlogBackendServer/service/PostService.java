package com.sparta.myBlogBackendServer.service;


import com.sparta.myBlogBackendServer.dto.PostDeleteDto;
import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import com.sparta.myBlogBackendServer.dto.PostResponseDto;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public Long update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.checkPassword(postRequestDto.getPassword());
        post.update(postRequestDto);
        return post.getId();
    }

    @Transactional
    public Long deletePost(Long id, PostDeleteDto postDeleteDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.checkPassword(postDeleteDto.getPassword());
        postRepository.deleteById(id);
        return id;
    }
}