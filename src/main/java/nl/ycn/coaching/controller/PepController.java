package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.database.HardskillService;
import nl.ycn.coaching.database.SoftskillService;
import nl.ycn.coaching.model.PersonalEducationPlan;
import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class PepController {

	@Autowired
	private HardskillRepository hardskillRepository;

	private List<PersonalHardskill> retrieveHardskillList() {
		//System.out.println(hardskillRepository.findAll() + "<---------------------");
		return hardskillRepository.findAll();
	}

//	@PostMapping("personaleducationplanpage")
//	public String postToPePpage(){
//		return "/dashboardpages/personaleducationplanpage";
//	}

	@GetMapping("personaleducationplanpage")
	public String goToPePpage(Model model){
		model.addAttribute("hardskillList", retrieveHardskillList());
		return "/dashboardpages/personaleducationplanpage";
	}

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){
		return "/dashboardpages/personalhardskillform";
	}

	@GetMapping("addsoftskillspage")
	public String getaddsoftskillpage() { return "/dashboardpages/addsoftskillpage"; }

//	@PostMapping("openhardskillform")
//	public String openHardskillForm(){
//		return "/dashboardpages/personalhardskillform";
//	}

	private HardskillService hardskillService;
	private SoftskillService softskillService;
	
	@Autowired
	public PepController(HardskillService hardskillService){
		this.hardskillService = hardskillService;
	}

	public PepController(SoftskillService softskillService) { this.softskillService = softskillService; }

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


		return "redirect:/personaleducationplanpage";
	}
}
