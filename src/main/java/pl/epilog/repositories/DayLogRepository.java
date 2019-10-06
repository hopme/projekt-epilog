package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.DayLog;
import pl.epilog.model.User;

import java.util.List;

public interface DayLogRepository extends JpaRepository<DayLog, Long> {

    List<DayLog> findAllByUser(User user);
    int countAllByUser(User user);

}
