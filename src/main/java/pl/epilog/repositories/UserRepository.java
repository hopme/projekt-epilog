package pl.epilog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.epilog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    long countByEmail(String email);

    User getByEmail(String email);

}