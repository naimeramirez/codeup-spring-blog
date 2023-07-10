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
    private final EmailService emailService;


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
    public String createNewPost() {
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitNewPost(@RequestParam String newPostTitle, @RequestParam String newPostBody) {
        Post post = new Post();
        post.setTitle(newPostTitle);
        post.setBody(newPostBody);

        User loggedInUser = userDao.findById(2L).get();
        post.setCreator(loggedInUser);

        postDao.save(post);

        return "redirect:/posts";
    }



}
