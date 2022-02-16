package alincova.springframework.pojistneudalosti.bootstrap;


import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.Pojisteni.Pojisteni;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import alincova.springframework.pojistneudalosti.repositories.PojisteniRepository;
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
        Pojisteni pojisteniVozidla = new Pojisteni("pojištění vozidla");
        patrik.getPojisteni().add(zivotni);
        patrik.getPojisteni().add(pojisteniVozidla);
        zivotni.setPojistenec(patrik);
        pojisteniVozidla.setPojistenec(patrik);

        pojistenecRepository.save(patrik);
        pojisteniRepository.save(zivotni);

        Pojistenec eva = new Pojistenec("Eva", "Adamcová", 30);
        eva.getPojisteni().add(pojisteniVozidla);
        //pojisteniVozidla.setPojistenec(eva);

        pojistenecRepository.save(eva);
        pojisteniRepository.save(pojisteniVozidla);

        System.out.println("Celkový počet pojištěnců:" + pojistenecRepository.count());
    }
}
