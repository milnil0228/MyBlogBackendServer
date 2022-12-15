package com.sparta.myBlogBackendServer.entity;

import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;

    public Post(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Post(PostRequestDto postRquestDto) {
        this.username = postRquestDto.getUsername();
        this.contents = postRquestDto.getContents();
        this.title = postRquestDto.getTitle();
        this.password = postRquestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto) {
        this.username = postRequestDto.getUsername();
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();
    }

    public void checkPassword(String password) {
        if(!this.password.equals(password)) throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }


}