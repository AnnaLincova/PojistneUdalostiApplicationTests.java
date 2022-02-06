package alincova.springframework.Pojistne_udalosti.controllers;

import alincova.springframework.Pojistne_udalosti.repositories.PojisteniRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
