package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.database.TraineeRepository;
import nl.ycn.coaching.services.AppUserService;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.services.BootcampService;
import nl.ycn.coaching.services.PepService;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.PersonalEducationPlan;
import nl.ycn.coaching.model.users.AppUser;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class TraineeController {

	@Autowired
	public PepService pepService;

	@Autowired
	public AppUserService appUserService;

	@Autowired
	public BootcampService bootcampService;

	@Autowired
	public BootcampRepository bootcampRepository;

	@Autowired
	public CourseRepository courseRepository;

	@Autowired
	public AppUserRepository appUserRepository;

	@Autowired
	public TraineeRepository traineeRepository;

	@GetMapping("/trainee/dashboard")
	public String getTraineeDashboard(Model model){

		AppUser user = appUserService.getActiveUser();
		Trainee trainee = traineeRepository.findByUsername(user.getUsername());
		Bootcamp bootcamp = trainee.getBootcamp();
		List<Course> courseList = bootcampService.getCourseList(bootcamp.getBootcampName());
		PersonalEducationPlan personalEducationPlan = new PersonalEducationPlan();

		//Fill the softskill list and set it
		personalEducationPlan.setPersonalSoftskillList(pepService.fillPersonalSoftskillList());

		//Fill the hardskill list and set it
		personalEducationPlan.setPersonalHardskillList(pepService.fillPersonalHardskillList());

		model.addAttribute("courseList", courseList);
		model.addAttribute("personalsoftskillList", personalEducationPlan.getPersonalSoftskillList());
		model.addAttribute("personalhardskillList", personalEducationPlan.getPersonalHardskillList());

		return "/trainee/dashboard";
	}

	@GetMapping("/trainee/courses")
	public String getCourses(Model model){

		AppUser user = appUserService.getActiveUser();
		Trainee trainee = traineeRepository.findByUsername(user.getUsername());
		Bootcamp bootcamp = trainee.getBootcamp();
		List<Course> courseList = bootcampService.getCourseList(bootcamp.getBootcampName());

		model.addAttribute("bootcamp", bootcamp);
		model.addAttribute("courseList", courseList);

		return "/trainee/courses";
	}

	@GetMapping(path="/trainee/course/{name}")
	public String getCourse(Model model, @PathVariable("name") String name){

		Course course = courseRepository.findByCoursename(name);

		model.addAttribute("course", course);

		return "/trainee/course";
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
	public String getContact(Model model){

		String username = appUserService.getActiveUser().getUsername();

		model.addAttribute("role", appUserService.getUser(username).getRole().toLowerCase());
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

	@PostMapping(path="trainee/contactdetails")
	public String updateContactDetails(
									String firstname,
									String lastname,
									String email,
									Date dateofbirth,
									String zipcode,
									String street,
									String streetNr,
									String city,
									String country,
									String telephonenumber){

		AppUser user = appUserService.getActiveUser();

		if (firstname != null) {
			user.setFirstName(firstname);
		}

		if (lastname != null) {
			user.setLastName(lastname);
		}

		if (email != null) {
			user.setEmail(email);
		}

		if (dateofbirth != null) {
			user.setDateofbirth(dateofbirth);
		}

		if (zipcode != null) {
			user.setZipcode(zipcode);
		}

		if (street != null) {
			user.setStreet(street);
		}

		if (streetNr != null) {
			user.setStreetNr(streetNr);
		}

		if (city != null) {
			user.setCity(city);
		}

		if (country != null) {
			user.setCountry(country);
		}

		if (telephonenumber != null) {
			user.setTelephonenumber(telephonenumber);
		}

		appUserRepository.save(user);

		return "redirect:/trainee/dashboard";
	}
}
