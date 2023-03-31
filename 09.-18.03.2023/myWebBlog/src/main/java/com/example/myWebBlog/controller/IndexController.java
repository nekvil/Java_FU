package com.example.myWebBlog.controller;

import com.example.myWebBlog.model.Post;
import com.example.myWebBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "fomchv/start");
        model.addAttribute("activeLink", "/");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "fomchv/about");
        model.addAttribute("activeLink", "/about");
        return "about";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "fomchv/login");
        model.addAttribute("activeLink", "/login");
        return "login";
    }
}
