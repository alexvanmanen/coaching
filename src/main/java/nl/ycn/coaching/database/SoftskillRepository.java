package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Softskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftskillRepository extends JpaRepository<Softskill, Long> {

	Softskill findBySoftskillId(int id);
	
	Softskill findByName(String name);

}
