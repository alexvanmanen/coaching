package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.PepService;
import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.database.AppUserService;

import nl.ycn.coaching.model.PersonalEducationPlan;

import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PepController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private PepService pepService;

	@Autowired
	private HardskillRepository hardskillRepository;

	@Autowired
	private SoftskillRepository softskillRepository;

	private List<PersonalHardskill> retrieveHardskillList() {
		return hardskillRepository.findAll();
	}

	private PersonalHardskill retrieveHardskillByName (String name) {
		return hardskillRepository.findByUsername(name);
	}

	@GetMapping("personaleducationplanpage")
	public String goToPepPage(Model model, String name){
		model.addAttribute("hardskillList", retrieveHardskillList());
		model.addAttribute ("personalHardskill", retrieveHardskillByName (name));
		return "/dashboardpages/personaleducationplanpage";
	}

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){
		return "/dashboardpages/personalhardskillform";
	}

	@GetMapping("addsoftskillspage")
	public String getaddsoftskillpage() { return "/dashboardpages/addsoftskillpage"; }

	@Autowired
	public PepController(PepService pepService){
		this.pepService = pepService;
	}

	@PostMapping("/createpersonalhardskill")
	public String createPersonalHardskill(String name, String description, String state, String start, String end){

		System.out.println("gegevens: " + name + ", " + description + ", " + state + ", " + start + "," + end);

		String username = appUserService.getActiveUser().getUsername();

		pepService.addHardskill (name, description, state, start, end, username);

		return "redirect:/personaleducationplanpage";
	}

	@PostMapping("/createsoftskill")
	public String createSoftskill(String name, String description){
		pepService.addSoftskill(name, description);

		return "redirect:/dashboardpage";
	}
}
