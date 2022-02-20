package alincova.springframework.pojistneudalosti.bootstrap;


import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.Pojisteni.Pojisteni;
import alincova.springframework.pojistneudalosti.Pojisteni.Smlouva;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import alincova.springframework.pojistneudalosti.repositories.PojisteniRepository;
import alincova.springframework.pojistneudalosti.repositories.SmlouvaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PojistenecRepository pojistenecRepository;
    private final PojisteniRepository pojisteniRepository;
    private final SmlouvaRepository smlouvaRepository;

    public BootStrapData(PojistenecRepository pojistenecRepository, PojisteniRepository pojisteniRepository, SmlouvaRepository smlouvaRepository) {
        this.pojistenecRepository = pojistenecRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.smlouvaRepository = smlouvaRepository;
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

        Smlouva zivotni1 = new Smlouva();
        patrik.getSmlouva().add(zivotni1);
        zivotni.setSmlouva(zivotni1);
        smlouvaRepository.save(zivotni1);


        pojistenecRepository.save(patrik);
        pojisteniRepository.save(zivotni);

        Pojistenec eva = new Pojistenec("Eva", "Adamcová", 30);
        eva.getPojisteni().add(pojisteniVozidla);
        //pojisteniVozidla.setPojistenec(eva);

        pojistenecRepository.save(eva);
        pojisteniRepository.save(pojisteniVozidla);

        System.out.println("Celkový počet pojištěnců:" + pojistenecRepository.count());
        System.out.println("Celkový počet smluv:" + smlouvaRepository.count());
    }
}
