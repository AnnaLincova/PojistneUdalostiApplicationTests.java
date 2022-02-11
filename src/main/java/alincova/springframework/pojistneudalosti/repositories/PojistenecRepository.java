package alincova.springframework.pojistneudalosti.repositories;

import alincova.springframework.pojistneudalosti.Pojisteni.Pojistenec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PojistenecRepository extends CrudRepository<Pojistenec, Long> {


}
