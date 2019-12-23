package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.PepService;
import nl.ycn.coaching.model.PersonalEducationPlan;
import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PepController {

	private PepService pepService;

	@PostMapping("personaleducationplanpage")
	public String goToPePpage(){
		return "/dashboardpages/personaleducationplanpage";
	}

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){ return "/dashboardpages/personalhardskillform"; }

	@GetMapping("createsoftskillform")
	public String getaddsoftskillpage() { return "/dashboardpages/createsoftskillpage"; }


	@Autowired
	public PepController(PepService pepService){
		this.pepService = pepService;
	}

	@PostMapping("/createpersonalhardskill")

	public String createPersonalHardskill(String name, String description, String state, String start, String end){

		System.out.println("gegevens: " + name + ", " + description + ", " + state + ", " + start + "," + end);
		
		pepService.addHardskill (name, description, state, start, end);
		System.out.println("gegevens: " + name + ", " + state);

		PersonalHardskill skill = new PersonalHardskill(name, description, state, start, end);
		Trainee trainee = new Trainee();
		PersonalEducationPlan pep = trainee.getPepPlan();
		pep.addHardskill(skill);


		return "/dashboardpages/personaleducationplanpage";
	}

	@PostMapping("/createsoftskill")

	public String createSoftskill(String name, String description){
		pepService.addSoftskill(name, description);

		return "redirect:/dashboardpage";
	}
}
