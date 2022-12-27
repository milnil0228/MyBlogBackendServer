package com.sparta.myBlogBackendServer.entity;

import com.sparta.myBlogBackendServer.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //post가 삭제될 경우 함께 삭제
    @OrderBy("id asc")  //id 순서대로 정렬
    private List<Comment> comments = new ArrayList<>();

    public Post(PostRequestDto postRequestDto, User user) {
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();
        this.user = user;
    }

    public void update(PostRequestDto postRequestDto) {
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();
    }


}