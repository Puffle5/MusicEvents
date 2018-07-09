package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewController {
    @GetMapping("/home")
    public String showSomething () {
        return "Hello";
    }
}
