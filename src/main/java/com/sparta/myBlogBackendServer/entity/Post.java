package com.sparta.myBlogBackendServer.entity;

import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
//    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

//    @Column(nullable = false)
//    private String password;

    public Post(PostRequestDto postRquestDto, User user) {
        this.contents = postRquestDto.getContents();
        this.title = postRquestDto.getTitle();
        this.user = user;
//        this.password = postRquestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto) {
//        this.username = user.getUsername();
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();
    }

//    public void checkPassword(String password) {
//        if(!this.password.equals(password)) throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//    }


}