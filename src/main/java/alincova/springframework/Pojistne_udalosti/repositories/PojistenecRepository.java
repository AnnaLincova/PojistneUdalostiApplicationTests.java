package alincova.springframework.Pojistne_udalosti.repositories;

import alincova.springframework.Pojistne_udalosti.Pojisteni.Pojistenec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PojistenecRepository extends CrudRepository<Pojistenec, Long> {


}
