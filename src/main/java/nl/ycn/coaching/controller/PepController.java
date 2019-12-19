package nl.ycn.coaching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PepController {

	@GetMapping("personalhardskillform")
	public String getpersonalhardskillform(){
		return "/dashboardpages/personalhardskillform";
	}

	@PostMapping("personalhardskillform")
	public String createPersonalHardskill(){
		//get active user

		return "/dashboardpages/personalhardskillform";
	}


}
