package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardskillRepository extends JpaRepository<PersonalHardskill, Long> {

    PersonalHardskill findByUsername(String name);

    PersonalHardskill findById(long id);

}
