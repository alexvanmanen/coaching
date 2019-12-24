package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.Softskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PepService {
	
	@Autowired
	private HardskillRepository hardskillRepository;

	@Autowired
	private SoftskillRepository softskillRepository;
	
	public void addHardskill(
			String name,
			String description,
			String state,
			String start,
			String end, String username) {
			PersonalHardskill hardskill = new PersonalHardskill (name, description, state, start, end, username);
			hardskillRepository.save(hardskill);
		}

	public void addSoftskill(
			String name,
			String description){
		Softskill softskill = new Softskill(name, description);
		softskillRepository.save(softskill);
	}
}

