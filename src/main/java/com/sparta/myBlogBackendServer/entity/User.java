package com.sparta.myBlogBackendServer.entity;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Length(min = 4, max = 10)
//    @Pattern(regexp = "^[a-z0-9]$")
    private String username;

    @Column(nullable = false)
    @Length(min = 8, max = 15)
//    @Pattern(regexp = "^[a-zA-Z0-9]$")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}