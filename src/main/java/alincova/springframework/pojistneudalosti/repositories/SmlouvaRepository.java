package alincova.springframework.pojistneudalosti.repositories;

import alincova.springframework.pojistneudalosti.Pojisteni.Smlouva;
import org.springframework.data.repository.CrudRepository;

public interface SmlouvaRepository extends CrudRepository<Smlouva, Long> {
}
