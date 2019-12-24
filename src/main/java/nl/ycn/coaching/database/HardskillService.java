package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HardskillService {
	
	@Autowired
	private HardskillRepository hardskillRepository;
	
	public void addHardskill(
			String name,
			String description,
			String state,
			String start,
			String end, String username) {
			PersonalHardskill hardskill = new PersonalHardskill (name, description, state, start, end, username);
			hardskillRepository.save(hardskill);
		}
	}

