package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.BootcampService;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.model.Course;
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
	
	private List<Course> retrieveCourseList() {
		return courseRepository.findAll();
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
