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

        posts.add(new Post(1,"Exploring the Versatility of JavaScript", "JavaScript is a dynamic programming language widely used for web development. It adds interactivity and functionality to websites, allowing you to create responsive and engaging user experiences. With JavaScript, you can manipulate HTML elements, handle events, validate forms, and perform complex calculations. Its versatility extends beyond web development, as JavaScript is also used in mobile app development and server-side programming. Learning JavaScript opens up a world of possibilities for creating interactive web applications and honing your coding skills."));

        posts.add(new Post(2,"Understanding the Basics of HTML", "HTML (Hypertext Markup Language) is the foundation of web development and an essential skill for aspiring coders. It provides the structure and layout for web pages, defining the various elements and content within. To get started with HTML, familiarize yourself with tags, which are enclosed in angle brackets (< >). Tags define different elements like headings, paragraphs, images, and links. Learning HTML opens the door to creating your own websites and understanding the structure behind the web pages you interact with every day."));

        posts.add(new Post(3,"Building Dynamic Web Applications with Python and Django", "Python is a versatile and beginner-friendly programming language with a strong focus on code readability. It has gained popularity in web development due to its simplicity and extensive libraries and frameworks. One such framework is Django, a high-level Python web framework that enables rapid development and clean, scalable code. Django follows the Model-View-Controller (MVC) architectural pattern, making it easier to build complex web applications. By combining Python and Django, you can create dynamic websites, handle databases, and implement user authentication systems. Exploring Python and Django provides a solid foundation for building robust web applications and delving deeper into the world of web development."));

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
