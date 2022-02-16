package alincova.springframework.pojistneudalosti.controllers;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.repositories.PojisteniRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PojisteniController {

    private final PojisteniRepository pojisteniRepository;

    public PojisteniController(PojisteniRepository pojisteniRepository) {
        this.pojisteniRepository = pojisteniRepository;
    }

    @RequestMapping("/pojisteni")
    public String getPojisteni(Model model){
        model.addAttribute("pojisteni", pojisteniRepository.findAll());
        return "pojisteni";
    }

}
