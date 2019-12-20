package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.HardskillService;
import nl.ycn.coaching.model.PersonalEducationPlan;
import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class PepController {

	@PostMapping("personaleducationplanpage")
	public String goToPePpage(){
		return "/dashboardpages/personaleducationplanpage";
	}

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){
		return "/dashboardpages/personalhardskillform";
	}

//	@PostMapping("openhardskillform")
//	public String openHardskillForm(){
//		return "/dashboardpages/personalhardskillform";
//	}

	private HardskillService hardskillService;
	
	@Autowired
	public PepController(HardskillService hardskillService){
		this.hardskillService = hardskillService;
	}
	
	@PostMapping("/createpersonalhardskill")

	public String createPersonalHardskill(String name, String description, String state, String start, String end){

		System.out.println("gegevens: " + name + ", " + description + ", " + state + ", " + start + "," + end);
		
		hardskillService.addHardskill (name, description, state, start, end);
//		System.out.println("gegevens: " + name + ", " + state);
//
//		PersonalHardskill skill = new PersonalHardskill(name, description, state, start, end);
//		Trainee trainee = new Trainee();
//		PersonalEducationPlan pep = trainee.getPepPlan();
//		pep.addHardskill(skill);


		return "/dashboardpages/personaleducationplanpage";
	}
}
