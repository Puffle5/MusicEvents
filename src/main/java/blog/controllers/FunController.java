package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FunController {
    @GetMapping("/antonioFace")
    public String antonioDetails (){
        return "FunPages/Antonio";

    }
}
