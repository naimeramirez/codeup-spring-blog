package codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndexPage() {
        return "<h1>Posts Index Page</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "<h1>View an individual post</h1>";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "<h1>Form for creating posts</h1>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPostPage() {
        return "<h1>Create a new post</h1>";
    }


}
