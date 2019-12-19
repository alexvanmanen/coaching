package nl.ycn.coaching.database;

import nl.ycn.coaching.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
