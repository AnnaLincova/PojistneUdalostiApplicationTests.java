package alincova.springframework.pojistneudalosti.controllers;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojisteni;
import alincova.springframework.pojistneudalosti.Pojisteni.Smlouva;
import alincova.springframework.pojistneudalosti.Pojisteni.TypPojisteni;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import alincova.springframework.pojistneudalosti.repositories.PojisteniRepository;
import alincova.springframework.pojistneudalosti.repositories.SmlouvaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SmlouvaController {
    private final SmlouvaRepository smlouvaRepository;
    private final PojisteniRepository pojisteniRepository;
    private final PojistenecRepository pojistenecRepository;

    public SmlouvaController(SmlouvaRepository smlouvaRepository, PojisteniRepository pojisteniRepository, PojistenecRepository pojistenecRepository) {
        this.smlouvaRepository = smlouvaRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistenecRepository = pojistenecRepository;
    }

    @GetMapping("/novasmlouva")
    public void novaSmlouva(Model model) {
        model.addAttribute("novasmlouva", new Smlouva());
        model.addAttribute("pojisteni", new Pojisteni(TypPojisteni.ZIVOTNI));
    }

    @PostMapping("/novasmlouva")
    //public String addSmlouva(@ModelAttribute Smlouva novasmlouva, Model model) {
    //smlouvaRepository.save(novasmlouva);
    //return "pojistenci";}

    @GetMapping(value = "/smlouvy")
    public String getSmlouva(Model model) {
        model.addAttribute("smlouvy", smlouvaRepository.findAll());
        return "smlouvy";
    }
}


