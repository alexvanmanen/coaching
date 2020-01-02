package nl.ycn.coaching.controller;


import net.bytebuddy.utility.RandomString;
import nl.ycn.coaching.database.AppUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HrController {

	@Autowired
	private AppUserService appUserService;

	//Mappings for HR-Employee
	@GetMapping("bootcamps")
	public String getBootcamps(){return "hremployee/bootcamps";}

	@GetMapping("users")
	public String getUsers(){return "hremployee/users";}

	@GetMapping("teams")
	public String getTeams(){return "hremployee/teams";}

	@GetMapping("skills")
	public String getSkills(){return "hremployee/skills";}

	@GetMapping("createsoftskillform")
	public String getSoftskillForm(){return "hremployee/createsoftskillform";}

	@GetMapping("register")
	public String register(Model model){
		String upperCaseLetters = RandomStringUtils.random(3, 65, 90, true, true);
		String lowerCaseLetters = RandomStringUtils.random(3, 97, 122, true, true);
		String numbers = RandomStringUtils.randomNumeric(3);
		String specialChar = RandomStringUtils.random(3, 33, 47, false, false);
		String totalChars = RandomStringUtils.randomAlphanumeric(3);
		String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
				.concat(numbers)
				.concat(specialChar)
				.concat(totalChars);
		List<Character> pwdChars = combinedChars.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toList());
		Collections.shuffle(pwdChars);
		String password = pwdChars.stream()
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		model.addAttribute("randomPassword", password);
		return "/hremployee/register";
	}

	@GetMapping("hrcalendar")
	public String getCalendar(){
		return "hremployee/calendar";}

	//register a new AppUser (from hremployee/register)
	@PostMapping("addappuser")
	public String register(String username, String firstname, String lastname, String email, String password, String roles){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		appUserService.registerUser(username,  firstname, lastname, email, encoder.encode(password), roles);
		return "/hremployee/users";
	}

}
