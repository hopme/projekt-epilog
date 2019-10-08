package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.Factor;

import java.util.List;


public interface FactorRepository extends JpaRepository<Factor, Long> {

    List<Factor>findAllByCategoryName(String categoryName);
    Factor findById(Long id);



}
