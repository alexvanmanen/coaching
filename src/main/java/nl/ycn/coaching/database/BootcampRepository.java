package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {

    Bootcamp findByBootcampName(String name);

}
