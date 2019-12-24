package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.PersonalSoftskill;
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
	
	@Autowired
	private PersonalSoftskillRepository personalSoftskillRepository;
	
	public void addHardskill(
			String name,
			String description,
			String state,
			String start,
			String end) {
			PersonalHardskill hardskill = new PersonalHardskill (name, description, state, start, end);
			hardskillRepository.save(hardskill);
		}

	public void addSoftskill(
			String name,
			String description){
		Softskill softskill = new Softskill(name, description);
		softskillRepository.save(softskill);
	}
	
	public void addPersonalSoftskill(
			String name,
			String report) {
		Softskill softskill = softskillRepository.findByName (name);
		String description = softskill.getDescription ();
		PersonalSoftskill personalSoftskill = new PersonalSoftskill (name, description, report);
		personalSoftskillRepository.save(personalSoftskill);
		
	}
}

