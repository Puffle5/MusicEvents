package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {
    @GetMapping("/musicGenres")
    public String displayGenres () {
        return "Genres/Genres";
    }
}
