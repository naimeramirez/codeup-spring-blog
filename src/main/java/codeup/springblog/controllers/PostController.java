package codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

//initializes all with /posts
@RequestMapping("/posts")

public class PostController {

    @GetMapping()
    @ResponseBody
    public String postsIndexPage() {
        return "<h1>Posts Index Page</h1>";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String individualPost(@PathVariable Long id) {
        return "<h1>View an individual post " + id + "</h1>";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createNewPost() {
        return "<h1>Form for creating posts</h1>";
    }

    @PostMapping("/create")
    @ResponseBody
    public String submitNewPost() {
        return "Create a new post";
    }



}
