// src/main/java/com/kubit/develup/entity/Post.java
package com.example.develup.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Post() {
        // JPA only
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }
}
