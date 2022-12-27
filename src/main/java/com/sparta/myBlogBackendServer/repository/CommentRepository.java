package com.sparta.myBlogBackendServer.repository;

import com.sparta.myBlogBackendServer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
