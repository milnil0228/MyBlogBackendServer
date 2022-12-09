package com.sparta.myblogbackendserver.entity;

import com.sparta.myblogbackendserver.dto.PostRequestDtro;
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
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Post(PostRequestDtro requestDtro) {
        this.username = requestDtro.getUsername();
        this.password = requestDtro.getPassword();
        this.title = requestDtro.getTitle();
        this.contents = requestDtro.getContents();
    }

    public void update(PostRequestDtro requestDtro) {
        this.username = requestDtro.getUsername();
        this.title = requestDtro.getTitle();
        this.contents = requestDtro.getContents();
    }
}