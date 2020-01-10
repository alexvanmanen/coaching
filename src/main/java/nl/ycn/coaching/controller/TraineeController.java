package nl.ycn.coaching.controller;

import nl.ycn.coaching.services.AppUserService;
import nl.ycn.coaching.services.PepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
public class TraineeController {

	@Autowired
	public PepService pepService;

	@Autowired
	public AppUserService appUserService;

	@GetMapping("/trainee/dashboard")
	public String getTraineeDashboard(){
		return "/trainee/dashboard";
	}

	@GetMapping("/trainee/courses")
	public String getCourses(){
		return "/trainee/courses";
	}

	@GetMapping("/trainee/calendar")
	public String getCalendar(){
		return "/trainee/calendar";
	}

	@GetMapping("/trainee/header")
	public String getHeader(){
		return "/trainee/header";
	}

	@GetMapping("/trainee/contactdetails")
	public String getContact(){
		return "/trainee/contactdetails";
	}

	@GetMapping("/trainee/accountsettings")
	public String getAccountSettings(){
		return "/trainee/accountsettings";
	}

	@PostMapping("/createpersonalhardskill")
	public String createPersonalHardskill(String name, String description, String report, String state, Date start, Date end){
		String username = appUserService.getActiveUser().getUsername();
		pepService.addHardskill (name, description, report, state, start, end, username);
		return "redirect:/trainee/personaleducationplanpage";
	}

	@PostMapping("/createpersonalsoftskill")
	public String createPersonalSoftskill(String name, String report){
		String username = appUserService.getActiveUser().getUsername();
		pepService.addPersonalSoftskill (name, report, username);
		return "redirect:/trainee/personaleducationplanpage";
	}
}
