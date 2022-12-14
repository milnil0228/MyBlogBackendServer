package com.sparta.myBlogBackendServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyBlogBackendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogBackendServerApplication.class, args);
    }

}