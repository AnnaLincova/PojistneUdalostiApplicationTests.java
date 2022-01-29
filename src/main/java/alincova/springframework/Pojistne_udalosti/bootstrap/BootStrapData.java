package alincova.springframework.Pojistne_udalosti.bootstrap;


import alincova.springframework.Pojistne_udalosti.Pojisteni.Pojistenec;
import alincova.springframework.Pojistne_udalosti.Pojisteni.Pojisteni;
import alincova.springframework.Pojistne_udalosti.repositories.PojistenecRepository;
import alincova.springframework.Pojistne_udalosti.repositories.PojisteniRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PojistenecRepository pojistenecRepository;
    private final PojisteniRepository pojisteniRepository;


    public BootStrapData(PojistenecRepository pojistenecRepository, PojisteniRepository pojisteniRepository) {
        this.pojistenecRepository = pojistenecRepository;
        this.pojisteniRepository = pojisteniRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        Pojistenec patrik = new Pojistenec("Patrik", "Novotný", 39);
        Pojisteni zivotni = new Pojisteni("životní");
        patrik.getPojisteni().add(zivotni);
        zivotni.getPojistenci().add(patrik);


        pojistenecRepository.save(patrik);
        pojisteniRepository.save(zivotni);


        Pojistenec eva = new Pojistenec("Eva", "Adamcová", 30);
        Pojisteni pojisteniVozidla = new Pojisteni("pojištění vozidla");

        pojistenecRepository.save(eva);
        pojisteniRepository.save(pojisteniVozidla);

        eva.getPojisteni().add(pojisteniVozidla);
        pojisteniVozidla.getPojistenci().add(eva);

        System.out.println("Celkový počet pojištěnců:" + pojistenecRepository.count());


    }
}
