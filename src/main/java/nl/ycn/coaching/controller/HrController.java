package nl.ycn.coaching.controller;


import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.CourseCreationDto;
import nl.ycn.coaching.model.users.AppUser;
import nl.ycn.coaching.model.users.Trainee;
import nl.ycn.coaching.services.AppUserService;
import nl.ycn.coaching.services.BootcampService;
import nl.ycn.coaching.services.HrService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HrController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private HrService hrService;
	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private BootcampRepository bootcampRepository;

	@Autowired
	private BootcampService bootcampService;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	//Mappings for HR-Employee
	@GetMapping("hremployee/bootcamps")
	public String getBootcamps(Model model) {
		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			model.addAttribute("activeBootcamps", hrService.getTopActiveBootcamps(100));
			model.addAttribute("finishedBootcamps", hrService.getTopFinishedBootcamps(100));

			return role.toLowerCase() + "/bootcamps";
		} catch (Exception e) {
			return "/login";
		}
	}

	@GetMapping("/hremployee/editbootcamp/{bootcampName}")
	public String getEditBootcampPage(Model model, @PathVariable("bootcampName") String bootcampName) {
		model.addAttribute("bootcamp", bootcampRepository.findByBootcampName(bootcampName));
		CourseCreationDto c = new CourseCreationDto(bootcampService.getCourseList(bootcampName));
		model.addAttribute("coursesdto", c);
		model.addAttribute("allcourses", courseRepository.findAll());
		return "/hremployee/editbootcamp";
	}

	@PostMapping("/hremployee/updatebootcamp")
	public String updateBootcamp(
							CourseCreationDto courseCreationDto,
							@RequestParam(value="action", required = false) String action,
							@RequestParam(value="bootcampname", required = false) String bootcampname,
							@RequestParam(value="bootcampbegindate", required = false) String beginDate,
							@RequestParam(value="bootcampenddate", required = false) String endDate){

		String[] actions = action.split(":");
		System.out.println(Arrays.toString(actions));
		Bootcamp camp = bootcampRepository.findByBootcampName(bootcampname);
		switch (actions[0]) {
			case "add_course":
				bootcampService.addCourse(courseCreationDto, camp);
				return "redirect:/hremployee/editbootcamp/"+actions[1];

			case "delete_course":
				bootcampService.deleteCourse(courseCreationDto, camp);
				return "redirect:/hremployee/editbootcamp/"+actions[1];

			case "save_bootcamp":
				bootcampService.saveBootcamp(courseCreationDto, bootcampname, beginDate, endDate);
				return "redirect:/hremployee/bootcamps";

			case "edit_bootcamp":
				return "redirect:/hremployee/editbootcamp/"+actions[1];

			case "activate_bootcamp":
				Bootcamp disBootcamp = bootcampRepository.findByBootcampName(actions[1]);
				boolean active = disBootcamp.getActive();
				disBootcamp.setActive(!active);
				bootcampRepository.save(disBootcamp);
				return "redirect:/hremployee/bootcamps";

			case "add_bootcamp":
				Bootcamp newBootcamp = new Bootcamp("new bootcamp");
				newBootcamp.setBeginDate("2020-01-01");
				newBootcamp.setEndDate("2020-01-02");
				newBootcamp.setCourseList("java");
				List<Course> course = new ArrayList<>();
				course.add(courseRepository.findByCoursename("java"));
				bootcampService.setCourseList(newBootcamp, course);
				return "redirect:/hremployee/editbootcamp/"+ newBootcamp.getBootcampName();

			default:
				return "redirect:/hremployee/bootcamps";
		}
	}

	//GetMapping to go to the create bootcamp page
	@GetMapping("/hremployee/addbootcamp")
	public String addBootcamp(Model model){
		model.addAttribute("bootcampName", "");
		CourseCreationDto c = new CourseCreationDto();
		model.addAttribute("coursesdto", c);
		model.addAttribute("courseList", courseRepository.findAll());
		return "/hremployee/createbootcamp";
	}


	@GetMapping({"/hremployee/dashboard","/hremployee"})
	public String getHrDashboard(Model model) {

		AppUser user = appUserService.getActiveUser();
		model.addAttribute("user", user);
		model.addAttribute("trainees", hrService.getTrainees("TRAINEE"));
		model.addAttribute("activeBootcamps", hrService.getTopActiveBootcamps(5));
		model.addAttribute("finishedBootcamps", hrService.getTopFinishedBootcamps(5));

		return "/hremployee/hrdashboard";
	}

	@GetMapping(path = "/hremployee/appuserinfo/{username}")
	public String getAppUserInfo(Model model, @PathVariable("username") String username) {

		model.addAttribute("appuser", appUserService.getUser(username));
		model.addAttribute("bootcampList", bootcampRepository.findAll());

		if (appUserService.getUser(username).getRole().equalsIgnoreCase("trainee")) {
			AppUser user = appUserService.getUser(username);
			Trainee trainee = (Trainee) user;
			model.addAttribute("bootcamp", trainee.getBootcamp().getBootcampName());
		}
		return "/hremployee/appuserinfo";
	}

	@PostMapping(path = "hremployee/updateappuserinfo/{username}")
	public String updateAppUserInfo(@PathVariable("username") String username,
									String firstname,
									String lastname,
									String email,
									String roles,
									String password,
									boolean enabled,
									boolean activated,
									Date dateofbirth,
									String zipcode,
									String street,
									String streetNr,
									String city,
									String country,
									String telephonenr,
									String bootcamp) {
		appUserService.updateAppUser(username,
				firstname,
				lastname,
				email,
				password,
				enabled,
				activated,
				dateofbirth,
				zipcode,
				street,
				streetNr,
				city,
				country,
				telephonenr,
				bootcamp);
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

    @GetMapping("/hremployee/skills")
    public String getSkills(Model model, String name) {
        try {
            AppUser user = appUserService.getActiveUser();
            String role = user.getRole();
            model.addAttribute("softskillslist", hrService.getSoftskillsForSkillspage());
            model.addAttribute("softskills", hrService.getSoftskillsForSkillspageByName(name));
            model.addAttribute("courseslist", hrService.getCoursesForSkillspage());
            model.addAttribute("course", hrService.getCourseForSkillspageByName(name));
            return role.toLowerCase() + "/skills";
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

    @PostMapping("/hremployee/createsoftskillform")
    public String createSoftskill(String name, String description) {
        hrService.addSoftskill(name, description);

        return "redirect:/hremployee/skills";
    }

    @GetMapping(path="/hremployee/softskilledit/{id}")
    public String getSoftskill(Model model, @PathVariable("id") int id) {
        model.addAttribute("name", hrService.getSoftskillsForSkillspageById(id).getName());
        model.addAttribute("description", hrService.getSoftskillsForSkillspageById(id).getDescription());

        return "/hremployee/softskilledit";
    }

    @PostMapping(path="/hremployee/softskilledit/{id}")
    public String editSoftskill(@PathVariable("id")int id, String name, String description){
        hrService.editSoftskill(id, name, description);
        return "redirect:/hremployee/skills";
    }

    @GetMapping("/hremployee/createcourseform")
    public String getCourseForm() {
        try {
            AppUser user = appUserService.getActiveUser();
            String role = user.getRole();
            return role.toLowerCase() + "/createcourseform";
        } catch (Exception e) {
            return "/login";
        }
    }

    @PostMapping("/hremployee/createcourseform")
    public String createCourse(String coursename, String coursedescription) {
        hrService.addCourse(coursename.toLowerCase(), coursedescription);

        return "redirect:/hremployee/skills";
    }

    @GetMapping(path="/hremployee/courseedit/{id}")
    public String getCourse(Model model, @PathVariable("id") int id) {
        model.addAttribute("coursename", hrService.getCourseForSkillspageById(id).getCoursename());
        model.addAttribute("coursedescription", hrService.getCourseForSkillspageById(id).getCoursedescription());

        return "/hremployee/courseedit";
    }

    @PostMapping(path="/hremployee/courseedit/{id}")
    public String editCourse(@PathVariable("id")int id, String coursename, String coursedescription){
        hrService.editCourse(id, coursename, coursedescription);
        return "redirect:/hremployee/skills";
    }

}
