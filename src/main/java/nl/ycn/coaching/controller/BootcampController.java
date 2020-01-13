package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.*;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BootcampController {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private BootcampService bootcampService;
	@Autowired
	private BootcampRepository bootcampRepository;
	
	@Autowired
	private TraineeRepository traineeRepository;

	private List<Course> retrieveCourseList() {
		return courseRepository.findAll();
	}
	
	private List<Trainee> retrieveTraineeList() {
		return traineeRepository.findAll ();
	}
	
	private List<Bootcamp> retrieveBootcampList() {
		return bootcampRepository.findAll ();
	}
	
	@GetMapping("createbootcamp")
	public String createbootcampform (Model model) {
		model.addAttribute ("courseList", retrieveCourseList ());
		return "/hremployee/createbootcamp";
	}
	
	@PostMapping("createbootcamp")
	public String createbootcamp (String bootcampName, String courseList) {
		bootcampService.addBootcamp (bootcampName, courseList);
		return "redirect:hremployee/bootcamps";
	}
}
