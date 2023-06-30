package codeup.springblog.controllers;

import codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//initializes all with /posts
@RequestMapping("/posts")

public class PostController {

    @GetMapping()
    public String postsIndexPage(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"Title1", "Title1 body"));
        posts.add(new Post(2,"Title2", "Title2 body"));
        posts.add(new Post(3,"Title3", "Title3 body"));

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable Long id, Model model) {
        model.addAttribute("id", "Showing post: " + id);
        return "posts/show";
    }

    @GetMapping("/create")
    public String createNewPost() {
        return "posts/create";
    }

    @PostMapping("/create")
    @ResponseBody
    public String submitNewPost() {
        return "Post Submitted";
    }



}
