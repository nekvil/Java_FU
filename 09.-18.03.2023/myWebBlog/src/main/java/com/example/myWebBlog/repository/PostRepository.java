package com.example.myWebBlog.repository;

import com.example.myWebBlog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
