package nl.ycn.coaching.controller;


import net.bytebuddy.utility.RandomString;
import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import nl.ycn.coaching.database.HrService;
import nl.ycn.coaching.model.users.AppUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HrController {

	@Autowired
	private AppUserService appUserService;


	@Autowired
	private HrService hrService;

	//Mappings for HR-Employee
	@GetMapping("hremployee/bootcamps")
	public String getBootcamps() {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			return role.toLowerCase() + "/bootcamps";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/dashboard")
	public String getHrDashboard(Model model){
		model.addAttribute("activeBootcamps",hrService.getTopBootcamps(5));
		return "/hremployee/hrdashboard";
	}



	@GetMapping("/hremployee/users")
	public String getUsers(Model model) {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			model.addAttribute("hremployees", appUserService.getAppUsersByRole("HREMPLOYEE"));
			model.addAttribute("trainees", appUserService.getAppUsersByRole("TRAINEE"));
			model.addAttribute("managers", appUserService.getAppUsersByRole("MANAGER"));
			model.addAttribute("talentmanagers", appUserService.getAppUsersByRole("TALENTMANAGER"));
			return "/" + role.toLowerCase() + "/users";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/teams")
	public String getTeams() {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			return "/" + role.toLowerCase() + "/teams";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/skills")
	public String getSkills() {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			return role.toLowerCase() + "/skills";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/createsoftskillform")
	public String getSoftskillForm() {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			return role.toLowerCase() + "/createsoftskillform";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/register")
	public String register(Model model) {

		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();

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
			return role.toLowerCase() + "/register";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/hrcalendar")
	public String getCalendar() {
		return "/hremployee/hrcalendar";
	}

	//register a new AppUser (from hremployee/register)
	@PostMapping("/hremployee/addappuser")
	public String register(String username, String firstname, String lastname, String email, String password, String roles) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		appUserService.registerUser(username, firstname, lastname, email, encoder.encode(password), roles, true, true);
		return "redirect:/hremployee/users";
	}

	@PostMapping("/hremployee/createsoftskill")
	public String createSoftskill(String name, String description) {
		hrService.addSoftskill(name, description);

		return "/hremployee/hrdashboard";
	}

}
