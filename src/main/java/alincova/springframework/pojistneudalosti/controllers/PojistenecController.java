package alincova.springframework.pojistneudalosti.controllers;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PojistenecController {
    private final PojistenecRepository pojistenecRepository;

    public PojistenecController(PojistenecRepository pojistenecRepository) {
        this.pojistenecRepository = pojistenecRepository;
    }

    @GetMapping(value = "/pojistenci")
    public void getPojistenci(Model model) {
        model.addAttribute("pojistenci", pojistenecRepository.findAll());
    }

    @GetMapping("/novypojistenec")
    public void novyPojistenec(Model model) {
        model.addAttribute("novypojistenec", new Pojistenec());
    }

    @PostMapping("/novypojistenec")
    public String addPojistenec(@ModelAttribute Pojistenec novypojistenec, Model model) {
        pojistenecRepository.save(novypojistenec);
        model.addAttribute("pojistenci", pojistenecRepository.findAll());
        return "pojistenci";
    }
}
