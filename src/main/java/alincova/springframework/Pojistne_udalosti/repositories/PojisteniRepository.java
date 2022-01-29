package alincova.springframework.Pojistne_udalosti.repositories;

import alincova.springframework.Pojistne_udalosti.Pojisteni.Pojisteni;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PojisteniRepository extends CrudRepository<Pojisteni, Long> {

}
