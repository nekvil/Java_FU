package com.example.myWebBlog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    private String content;
    private LocalDateTime createdAt;

    public Comment(Long id, Post post, String content, LocalDateTime createdAt) {
        this.id = id;
        this.post = post;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment(Post post, String content, LocalDateTime createdAt) {
        this.post = post;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
