package nl.ycn.coaching.database;

import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.PersonalSoftskill;
import nl.ycn.coaching.model.Softskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PepService {
	
	@Autowired
	private HardskillRepository hardskillRepository;

	@Autowired
	private SoftskillRepository softskillRepository;

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
	/*TODO change softskill to personalsoftskill*/
	public List<Softskill> fillPersonalSoftskillList() {
		List<Softskill> list = new ArrayList<Softskill>();
		String username = appUserService.getActiveUser().getUsername();

		List<Softskill> databaseSoftskills = softskillRepository.findAll();

		for (Softskill entry : databaseSoftskills) {

			list.add(entry);

			//Dit moet eigenlijk gebeuren, maar personalSoftskill bestaat nog niet, dus vandaar gecomment.
			/*
			if (entry.getUsername().equals(username)) {
				list.add(entry);
			}
			 */
		}

		return list;
	}
	
	@Autowired
	private PersonalSoftskillRepository personalSoftskillRepository;
	
	public void addHardskill(
			String name,
			String description,
			String state,
			String start,
			String end,
			String username) {
			PersonalHardskill hardskill = new PersonalHardskill (name, description, state, start, end, username);
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

