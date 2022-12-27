package com.sparta.myBlogBackendServer.service;

import com.sparta.myBlogBackendServer.dto.CommentRequestDto;
import com.sparta.myBlogBackendServer.entity.Comment;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.repository.CommentRepository;
import com.sparta.myBlogBackendServer.repository.PostRepository;
import com.sparta.myBlogBackendServer.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public void createComment(Long id, CommentRequestDto commentRequestDto, Claims claims) {
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        Comment comment = new Comment(commentRequestDto, post, user);
        commentRepository.save(comment);
    }

    public void updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        commentRepository.save(comment);
    }
}
