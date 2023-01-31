package com.sparta.myBlogBackendServer.service;


import com.sparta.myBlogBackendServer.dto.CommentRequestDto;
import com.sparta.myBlogBackendServer.dto.PostDeleteDto;
import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import com.sparta.myBlogBackendServer.dto.PostResponseDto;
import com.sparta.myBlogBackendServer.entity.Post;
import com.sparta.myBlogBackendServer.entity.User;
import com.sparta.myBlogBackendServer.entity.UserRoleEnum;
import com.sparta.myBlogBackendServer.jwt.JwtUtil;
import com.sparta.myBlogBackendServer.repository.PostRepository;
import com.sparta.myBlogBackendServer.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public void createPost(PostRequestDto postRequestDto, HttpServletRequest request) {
        //Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        System.out.println(token);
        Claims claims;

        //토큰이 있는 경우에만 게시글 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInformationFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Post post = new Post(postRequestDto, user);
            postRepository.save(post);
        }
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponseDto::new).collect(Collectors.toList());   //순환참조 문제
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public void update(Long id, PostRequestDto postRequestDto, HttpServletRequest request) {
        //Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에만 게시글 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInformationFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Post post = postRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
            );

            UserRoleEnum role = user.getRole();
            System.out.println(role);
            if (user.getUsername().equals(post.getUser().getUsername()) || role.equals(UserRoleEnum.ADMIN)) {
                post.update(postRequestDto);

                postRepository.save(post);
            } else {
                throw new IllegalArgumentException("접근할 수 있는 권한이 없습니다.");
            }
        }
    }

    @Transactional
    public void deletePost(Long id, HttpServletRequest request) {
        //Request에서 토큰ㄴ 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에만 게시글 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInformationFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Post post = postRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
            );

            UserRoleEnum role = user.getRole();
            System.out.println(role);
            if (user.getUsername().equals(post.getUser().getUsername()) || role.equals(UserRoleEnum.ADMIN)) {
                postRepository.delete(post);
            } else {
                throw new IllegalArgumentException("접근할 수 있는 권한이 없습니다.");
            }
        }
    }
}