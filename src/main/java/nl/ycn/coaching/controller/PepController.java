package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.PepService;
import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.database.PersonalSoftskillRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.database.AppUserService;

import nl.ycn.coaching.model.PersonalEducationPlan;

import nl.ycn.coaching.model.PersonalHardskill;
import nl.ycn.coaching.model.PersonalSoftskill;
import nl.ycn.coaching.model.Softskill;
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
	private PersonalSoftskillRepository personalSoftskillRepository;
	@Autowired
	private SoftskillRepository softskillRepository;

	private List<PersonalHardskill> retrieveHardskillList() {
		return hardskillRepository.findAll();
	}

	private PersonalHardskill retrieveHardskillByName (String name) {
		return hardskillRepository.findByName(name);
	}

	private List<PersonalSoftskill> retrievePersonalSoftskillList() {
		return personalSoftskillRepository.findAll ();
	}

	private PersonalSoftskill retrievePersonalSoftskillByName (String name) {
		return personalSoftskillRepository.findByName (name);
	}

	private List<Softskill> retrieveSoftskillList() {
		System.out.println (softskillRepository.findAll ());
		return softskillRepository.findAll ();
	}

	private Softskill retrieveSoftskillByName (String name) {
		return softskillRepository.findByName (name);
	}

	@GetMapping("personaleducationplanpage")
	public String goToPepPage(Model model, String name){
		PersonalEducationPlan personalEducationPlan = new PersonalEducationPlan();

		//Fill the softskill list and set it
		personalEducationPlan.setPersonalSoftskillList(pepService.fillPersonalSoftskillList());

		//Fill the hardskill list and set it
		personalEducationPlan.setPersonalHardskillList(pepService.fillPersonalHardskillList());

		model.addAttribute("personalSoftskillList", personalEducationPlan.getPersonalSoftskillList());
		model.addAttribute ("personalSoftskill", retrievePersonalSoftskillByName(name));
		model.addAttribute("hardskillList", personalEducationPlan.getPersonalHardskillList());
		model.addAttribute ("personalHardskill", retrieveHardskillByName(name));

		return "/dashboardpages/personaleducationplanpage";
	}

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){
		return "/dashboardpages/personalhardskillform";
	}

	@GetMapping("personalsoftskillform")
	public String getpersonalsoftskillform(Model model, String name){
		model.addAttribute ("softskillList", retrieveSoftskillList ());
		model.addAttribute ("softskill", retrieveSoftskillByName (name));
		return "/dashboardpages/personalsoftskillform";
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

	@PostMapping("/createpersonalsoftskill")
	public String createPersonalSoftskill(String name, String description, String report){

		String username = appUserService.getActiveUser().getUsername();

		pepService.addPersonalSoftskill (name, report, username);
		return "redirect:/personaleducationplanpage";
	}

	@PostMapping("/createsoftskill")
	public String createSoftskill(String name, String description){
		pepService.addSoftskill(name, description);

		return "redirect:/dashboardpage";
	}
}
