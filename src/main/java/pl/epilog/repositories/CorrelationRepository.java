package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.Correlation;

import java.util.List;

public interface CorrelationRepository extends JpaRepository<Correlation, Long> {

    Correlation findFirstByFactorIdAndUserId(Long factor_id, Long user_id);
    List<Correlation> findAllByUserId(Long user_id);



}
