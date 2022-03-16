package alincova.springframework.pojistneudalosti.bootstrap;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import alincova.springframework.pojistneudalosti.Pojisteni.Smlouva;
import alincova.springframework.pojistneudalosti.repositories.PojistenecRepository;
import alincova.springframework.pojistneudalosti.repositories.SmlouvaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static alincova.springframework.pojistneudalosti.Pojisteni.TypPojisteni.ZIVOTNI;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PojistenecRepository pojistenecRepository;

    private final SmlouvaRepository smlouvaRepository;

    public BootStrapData(PojistenecRepository pojistenecRepository, SmlouvaRepository smlouvaRepository) {
        this.pojistenecRepository = pojistenecRepository;
        this.smlouvaRepository = smlouvaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Pojistenec patrik = new Pojistenec("Patrik", "Novotný", 39);

        Smlouva zivotni = new Smlouva(Instant.parse("2022-03-16T10:00:00Z"), Instant.parse("2023-03-16T10:00:00Z"), ZIVOTNI);
        patrik.getSmlouvy().add(zivotni);
        smlouvaRepository.save(zivotni);
        pojistenecRepository.save(patrik);

        Pojistenec eva = new Pojistenec("Eva", "Adamcová", 30);

        pojistenecRepository.save(eva);

        System.out.println("Celkový počet pojištěnců:" + pojistenecRepository.count());
        System.out.println("Celkový počet smluv:" + smlouvaRepository.count());
    }
}
