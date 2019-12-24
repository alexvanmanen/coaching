package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalSoftskill;
import nl.ycn.coaching.model.Softskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftskillRepository extends JpaRepository<Softskill, Long> {

    Softskill findByName(String name);


}
