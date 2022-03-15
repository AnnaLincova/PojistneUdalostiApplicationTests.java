package alincova.springframework.pojistneudalosti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObecniController {

    @GetMapping(value = "/index")
    public String Rozcestnik() {
        return "index";
    }
}
