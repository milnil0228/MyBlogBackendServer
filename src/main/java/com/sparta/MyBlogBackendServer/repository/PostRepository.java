package com.sparta.MyBlogBackendServer.repository;


import com.sparta.MyBlogBackendServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findAllByOrderByModifiedAtDesc();
}