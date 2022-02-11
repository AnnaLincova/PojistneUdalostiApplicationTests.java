package alincova.springframework.pojistneudalosti.repositories;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojisteni;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PojisteniRepository extends CrudRepository<Pojisteni, Long> {

}
