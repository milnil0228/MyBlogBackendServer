package com.sparta.myBlogBackendServer.repository;


import com.sparta.myBlogBackendServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findAllByOrderByModifiedAtDesc();
}