package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.CourseCreationDto;
import nl.ycn.coaching.model.users.AppUser;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		for (String course : courseArray){
			if (courseRepository.findByName(course) != null) {
				coursesList.add(courseRepository.findByName(course));
			}
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

		for (Course course : courses){
			courseNames.add(course.getName());
		}
		String courseListString = String.join(",", courseNames);
		bootcamp.setCourseList(courseListString);
		bootcampRepository.save(bootcamp);
	}


	public void addCourse(CourseCreationDto courseCreationDto, Bootcamp camp) {
		List<Course> list = courseCreationDto.getCourses();
		Course c = new Course("NewCourse", "description");
		list.add(c);
		setCourseList(camp, list);
	}

	public void deleteCourse(CourseCreationDto courseCreationDto, Bootcamp camp) {
	}

	public void saveBootcamp(CourseCreationDto courseCreationDto, Bootcamp camp, String name, String beginDate, String endDate) {
		if (camp.getName().equals(name)) {
			List<Course> list = courseCreationDto.getCourses();
			setCourseList(camp, list);
		} else {
			Bootcamp bootcamp = new Bootcamp(name);
			bootcamp.setBeginDate(beginDate);
			bootcamp.setEndDate(endDate);
			setCourseList(bootcamp, courseCreationDto.getCourses());
		}
	}
}
