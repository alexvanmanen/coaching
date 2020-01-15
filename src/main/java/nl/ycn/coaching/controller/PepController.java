package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.PepService;
import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.database.PersonalSoftskillRepository;
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

import java.sql.Date;
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
	@Autowired
	public PepController(PepService pepService){
		this.pepService = pepService;
	}

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
		return softskillRepository.findAll ();
	}

	private Softskill retrieveSoftskillByName (String name) {
		return softskillRepository.findByName (name);
	}

	@GetMapping("/trainee/personaleducationplanpage")
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

		return "/trainee/personaleducationplanpage";
	}

	@GetMapping("/trainee/personalhardskillform")
	public String getpersonalhardskillform(){
		return "/trainee/personalhardskillform";
	}

	@GetMapping("/trainee/personalsoftskillform")
	public String getpersonalsoftskillform(Model model, String name){
		model.addAttribute ("softskillList", retrieveSoftskillList ());
		model.addAttribute ("softskill", retrieveSoftskillByName (name));
		return "/trainee/personalsoftskillform";
	}

	@GetMapping("addsoftskillspage")
	public String getaddsoftskillpage() {
		return "/trainee/addsoftskillpage";
	}

}
