package com.sparta.myBlogBackendServer.service;

import com.sparta.myBlogBackendServer.dto.CommentRequestDto;
import com.sparta.myBlogBackendServer.entity.Comment;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.entity.UserRoleEnum;
import com.sparta.myBlogBackendServer.repository.CommentRepository;
import com.sparta.myBlogBackendServer.repository.PostRepository;
import com.sparta.myBlogBackendServer.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    @Transactional
    public void createComment(Long id, CommentRequestDto commentRequestDto, Claims claims) {
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("유저 정보가 존재하지 않습니다.")
        );

        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        Comment comment = new Comment(commentRequestDto, post, user);
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Long commentId, CommentRequestDto commentRequestDto, Claims claims) {
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("유저 정보가 존재하지 않습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        UserRoleEnum role = user.getRole();
        if (user.getUsername().equals(comment.getUser().getUsername()) || role.equals(UserRoleEnum.ADMIN)) {
            comment.update(commentRequestDto);
            commentRepository.save(comment);
        } else {
            throw new IllegalArgumentException("접근할 수 있는 권한이 없습니다.");
        }
    }

    public void deleteComment(Long commentId, Claims claims) {
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("유저 정보가 존재하지 않습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        UserRoleEnum role = user.getRole();
        if (user.getUsername().equals(comment.getUser().getUsername()) || role.equals(UserRoleEnum.ADMIN)) {
            commentRepository.delete(comment);
        } else {
            throw new IllegalArgumentException("접근할 수 있는 권한이 없습니다.");
        }
    }
}
