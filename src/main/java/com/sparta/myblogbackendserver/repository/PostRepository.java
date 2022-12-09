package com.sparta.myblogbackendserver.repository;


import com.sparta.myblogbackendserver.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findAllByOrderByModifiedAtDesc();
}