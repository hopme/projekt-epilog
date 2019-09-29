package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.Factor;

public interface FactorRepository extends JpaRepository<Factor, Long> {
}
