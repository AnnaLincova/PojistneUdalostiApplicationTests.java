package alincova.springframework.pojistneudalosti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObecnyController {

    @GetMapping(value = "/")
    public String rozcestnik() {
        return "index";
    }
}
