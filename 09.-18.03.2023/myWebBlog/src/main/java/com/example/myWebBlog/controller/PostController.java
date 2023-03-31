package com.example.myWebBlog.controller;

import com.example.myWebBlog.model.Comment;
import com.example.myWebBlog.model.Post;
import com.example.myWebBlog.repository.CommentRepository;
import com.example.myWebBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id))
            return "redirect:/";

        model.addAttribute("title", "fomchv/posts");

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> postList = new ArrayList<>();
        post.ifPresent(postList::add);
        model.addAttribute("post", postList);

        List<Comment> commentList = commentRepository.findCommentsByPostId(id);
        model.addAttribute("comment", commentList);

        return "post-page";
    }

    @GetMapping("/posts/{id}/edit")
    public String postEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id))
            return "redirect:/";
        model.addAttribute("title", "fomchv/posts");
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> postList = new ArrayList<>();
        post.ifPresent(postList::add);
        model.addAttribute("post", postList);
        return "post-edit";
    }

    @GetMapping("/posts/add")
    public String postAdd(Model model) {
        model.addAttribute("title", "fomchv/posts");
        return "post-add";
    }

    @PostMapping("/posts/add")
    public String postAddPost(@RequestParam String title, @RequestParam String announcement, @RequestParam String content, Model model){
        model.addAttribute("title", "fomchv/posts");
        Post post = new Post(title, announcement, content, LocalDateTime.now());
        postRepository.save(post);
        return "redirect:/";
    }

    @PostMapping("/posts/{id}/edit")
    public String postEditPost(@PathVariable(value = "id") long id,@RequestParam String title, @RequestParam String announcement, @RequestParam String content, Model model){
        model.addAttribute("title", "fomchv/posts");
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnnouncement(announcement);
        post.setContent(content);
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.save(post);
        return "redirect:/";
    }

    @PostMapping("/posts/{id}/remove")
    public String postRemovePost(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("title", "fomchv/posts");
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/";
    }

    @PostMapping("/posts/{id}/comment")
    public String postAddCommentPost(@PathVariable(value = "id") long id, @RequestParam String content, Model model){
        model.addAttribute("title", "fomchv/posts");
        Post post = postRepository.findById(id).orElseThrow();
        Comment comment = new Comment(post, content, LocalDateTime.now());
        commentRepository.save(comment);
        return "redirect:/posts/{id}";
    }
}
