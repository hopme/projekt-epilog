package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.DayLog;

public interface DayLogRepository extends JpaRepository<DayLog, Long> {
}
