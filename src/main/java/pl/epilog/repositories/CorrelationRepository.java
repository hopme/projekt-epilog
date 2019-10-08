package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.Correlation;

public interface CorrelationRepository extends JpaRepository<Correlation, Long> {


}
