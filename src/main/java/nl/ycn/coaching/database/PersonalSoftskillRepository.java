package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalSoftskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalSoftskillRepository extends JpaRepository<PersonalSoftskill, Long> {
	
	PersonalSoftskill findByName(String name);
}
