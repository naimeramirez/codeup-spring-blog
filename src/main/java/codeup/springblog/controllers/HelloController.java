package codeup.springblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")

    @ResponseBody
    public String sayHello(@RequestParam @Nullable String name) {
        if (name == null) {
            name = "world";
        }
        return "<h1>Hello " + name + "!</h1>";
    }

    @GetMapping("/hello/{personName}")
    @ResponseBody
    public String sayHelloToName(@PathVariable String personName) {
        return "<h1>Hello " + personName + "!</h1>";
    }


}
