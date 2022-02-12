package alincova.springframework.pojistneudalosti.controllers;

import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.model.IModel;

@Controller
public class PojistenecController {
    private final PojistenecRepository pojistenecRepository;

    public PojistenecController(PojistenecRepository pojistenecRepository) {
        this.pojistenecRepository = pojistenecRepository;
    }

    @RequestMapping(value = "/pojistenci", method = RequestMethod.GET)
    public String getPojistenci(Model model){
        model.addAttribute("pojistenci", pojistenecRepository.findAll());
        return "pojistenci";
    }


}