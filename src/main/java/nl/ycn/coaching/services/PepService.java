package nl.ycn.coaching.services;

import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.database.PersonalSoftskillRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.PersonalSoftskill;
import nl.ycn.coaching.model.Softskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PepService {
	
	@Autowired
	private HardskillRepository hardskillRepository;

	@Autowired
	private SoftskillRepository softskillRepository;

	@Autowired
	private PersonalSoftskillRepository personalSoftskillRepository;

	@Autowired
	private AppUserService appUserService;

	/* Fill then Hardskill list of the active user then return it*/
	public List<PersonalHardskill> fillPersonalHardskillList() {
		List<PersonalHardskill> list = new ArrayList<PersonalHardskill>();
		String username = appUserService.getActiveUser().getUsername();

		List<PersonalHardskill> databasePersonalHardskills = hardskillRepository.findAll();

		for (PersonalHardskill entry : databasePersonalHardskills) {

			if (entry.getUsername().equals(username)) {
				list.add(entry);
			}
		}

		return list;
	}

	/* Fill then Softskill list of the active user then return it*/
	public List<PersonalSoftskill> fillPersonalSoftskillList() {
		List<PersonalSoftskill> list = new ArrayList<PersonalSoftskill>();

		String username = appUserService.getActiveUser().getUsername();

		List<PersonalSoftskill> databasePersonalSoftskills = personalSoftskillRepository.findAll();

		for (PersonalSoftskill entry : databasePersonalSoftskills) {

			if (entry.getUsername().equals(username)) {
				list.add(entry);
			}

		}

		return list;
	}

	public void addHardskill(
			String name,
			String description,
			String report,
			String state,
			Date start,
			Date end,
			String username) {
			PersonalHardskill hardskill = new PersonalHardskill (name, description, report, state, start, end, username);
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
			String report,
			String username) {
		Softskill softskill = softskillRepository.findByName (name);
		String description = softskill.getDescription ();
		PersonalSoftskill personalSoftskill = new PersonalSoftskill (name, description, report, username);
		personalSoftskillRepository.save(personalSoftskill);
		
	}
}

