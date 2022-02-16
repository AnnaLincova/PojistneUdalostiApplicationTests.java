package alincova.springframework.pojistneudalosti.controllers;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/novypojistenec")
    public String novyPojistenec(Model model) {
        model.addAttribute("novypojistenec", new Pojistenec());
        return "novypojistenec";
    }
    @PostMapping("/novypojistenec")
    public String addPojistenec(@ModelAttribute Pojistenec novypojistenec){
        pojistenecRepository.save(novypojistenec);
        pojistenecRepository.findAll();
        return "pojistenci";
    }

}
