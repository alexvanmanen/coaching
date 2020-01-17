package nl.ycn.coaching.services;

import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.CourseCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcampService {

	@Autowired
	private BootcampRepository bootcampRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	public void setBootcampRepository(BootcampRepository bootcampRepository) {
		this.bootcampRepository = bootcampRepository;
	}

	public void addBootcamp(
			String bootcampName,
			String courseList) {
		Bootcamp bootcamp = new Bootcamp(bootcampName.toLowerCase(), courseList);
		bootcampRepository.save(bootcamp);
	}

	public Bootcamp updateBootcamp(String bootcamp) {
		return bootcampRepository.findByBootcampName(bootcamp);
	}

	public List<Course> getCourseList(String bootcampName) {
		Bootcamp camp = bootcampRepository.findByBootcampName(bootcampName);
		List<Course> coursesList = new ArrayList<>();
		String[] courseArray = camp.getCourseList().split(",");

		for (String course : courseArray) {
			coursesList.add(courseRepository.findByCoursename(course));
		}

		return coursesList;
	}

	public void updateCourseList(String bootcampName, String courses) {
		Bootcamp camp = bootcampRepository.findByBootcampName(bootcampName);
		camp.setCourseList(courses);
		bootcampRepository.save(camp);
	}

	public void setCourseList(Bootcamp bootcamp, List<Course> courses) {
		List<String> courseNames = new ArrayList<>();

		for (Course course : courses) {
			courseNames.add(course.getCoursename());
		}
		String courseListString = String.join(",", courseNames);
		bootcamp.setCourseList(courseListString);
		bootcampRepository.save(bootcamp);



	}

	public void saveBootcamp(CourseCreationDto courseCreationDto, String name, String beginDate, String endDate) {
		if (bootcampRepository.findByBootcampName(name) != null) {
			List<Course> list = courseCreationDto.getCourses();
			setCourseList(bootcampRepository.findByBootcampName(name), list);
		} else {
			Bootcamp bootcamp = new Bootcamp(name);
			bootcamp.setBeginDate(beginDate);
			bootcamp.setEndDate(endDate);
			setCourseList(bootcamp, courseCreationDto.getCourses());
		}
		if(bootcampRepository.findByBootcampName("new bootcamp") != null){
			bootcampRepository.delete(bootcampRepository.findByBootcampName("new bootcamp"));
		}

	}

	public void deleteCourse(CourseCreationDto courseCreationDto, Bootcamp camp) {
	}

	public void addCourse(CourseCreationDto courseCreationDto, Bootcamp camp) {
		List<Course> list = courseCreationDto.getCourses();
		Course c = new Course("new course", "description");
		list.add(c);
		setCourseList(camp, list);
	}


}
