package nl.ycn.coaching.controller;


import net.bytebuddy.utility.RandomString;
import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.HrService;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.users.AppUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HrController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private BootcampRepository bootcampRepository;

	@Autowired
	private HrService hrService;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	//Mappings for HR-Employee
	@GetMapping("hremployee/bootcamps")
	public String getBootcamps(Model model) {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			model.addAttribute("activeBootcamps", hrService.getTopBootcamps(100));
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

	@GetMapping(path="/hremployee/appuserinfo/{username}")
	public String getAppUserInfo(Model model , @PathVariable("username") String username){

		model.addAttribute("role", appUserService.getUser(username).getRole().substring(0,1).toUpperCase().substring(1).toLowerCase());
		model.addAttribute("username", appUserService.getUser(username).getUsername());
		model.addAttribute("firstname", appUserService.getUser(username).getFirstName());
		model.addAttribute("lastname", appUserService.getUser(username).getLastName());
		model.addAttribute("email", appUserService.getUser(username).getEmail());
		model.addAttribute("street", appUserService.getUser(username).getStreet());
		model.addAttribute("streetnr", appUserService.getUser(username).getStreetNr());
		model.addAttribute("zipcode", appUserService.getUser(username).getZipcode());
		model.addAttribute("city", appUserService.getUser(username).getCity());
		model.addAttribute("country", appUserService.getUser(username).getCountry());
		model.addAttribute("bootcampList", bootcampRepository.findAll());
		model.addAttribute("telephonenumber",appUserService.getUser(username).getTelephonenumber());
		model.addAttribute("dateofbirth", appUserService.getUser(username).getDateofbirth());
		return "/hremployee/appuserinfo";
	}

	@PostMapping(path="hremployee/updateappuserinfo/{username}")
	public String updateAppUserInfo(@PathVariable("username") String username,
									String firstname,
									String lastname,
									String email,
									String roles,
									String bootcamp,
									boolean enabled,
									boolean activated,
									Date dateofbirth,
									String zipcode,
									String street,
									String streetNr,
									String city,
									String country,
									String telephonenumber){
		appUserService.updateAppUser(username,
				firstname,
				lastname,
				email,
				roles,
				bootcamp,
				enabled,
				activated,
				dateofbirth,
				zipcode,
				street,
				streetNr,
				city,
				country,
				telephonenumber);
		return "redirect:/hremployee/users";
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
			return role.toLowerCase() + "/teams";
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
	public String register(String username,
						   String firstname,
						   String lastname,
						   String email,
						   String password,
						   String roles,
						   boolean enabled,
						   boolean activated) {


		appUserService.registerUser(
							username,
							firstname,
							lastname,
							email,
							encoder.encode(password),
							roles,
							enabled,
							activated);

		return "redirect:/hremployee/users";
	}

	@PostMapping("/hremployee/createsoftskill")
	public String createSoftskill(String name, String description) {
		hrService.addSoftskill(name, description);

		return "/hremployee/hrdashboard";
	}


}
