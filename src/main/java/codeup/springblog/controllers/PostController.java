package codeup.springblog.controllers;

import codeup.springblog.models.EmailService;
import codeup.springblog.models.Post;
import codeup.springblog.models.User;
import codeup.springblog.repositories.PostRepository;
import codeup.springblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
//initializes all with /posts
@RequestMapping("/posts")

public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private EmailService emailService;


    @GetMapping("")
    public String postsIndexPage(Model model) {
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postDao.findById(id);
        if (optionalPost.isEmpty()) {
            return "home";
        }
        model.addAttribute("post", optionalPost.get());
        return "/posts/show";
    }

    @GetMapping("/create")
    public String createNewPost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitNewPost(@ModelAttribute Post post) {

        emailService.prepareAndSend(post,"New Post created", "Your New Post has been created");

        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editPost(@PathVariable Long id, Model model) {
        Post postEdit = postDao.getReferenceById(id);
        model.addAttribute("post", postEdit);
        return "/posts/create";
    }



}
