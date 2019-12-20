package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardskillRepository extends JpaRepository<PersonalHardskill, Long> {

}
