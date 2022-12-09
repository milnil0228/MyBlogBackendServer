package com.sparta.myblogbackendserver.service;

import com.sparta.myblogbackendserver.dto.PostRequestDtro;
import com.sparta.myblogbackendserver.entity.Post;
import com.sparta.myblogbackendserver.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;    //서비스는 레퍼지토리를 불러옴

    @Transactional
    public Post createPost(PostRequestDtro requestDtro) {
        Post post = new Post(requestDtro);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public Post getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        return post;
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, PostRequestDtro requestDtro) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDtro);
        return post.getId();
    }

    @Transactional
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
