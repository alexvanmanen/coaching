package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
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
		String[] courseArray = camp.getCourseList().split(", ");

		for (String course : courseArray){
			coursesList.add(courseRepository.findByName(course));
		}

		return coursesList;
	}

	public void updateCourseList(String bootcampName, String courses) {
		Bootcamp camp = bootcampRepository.findByBootcampName(bootcampName);
		camp.setCourseList(courses);
		bootcampRepository.save(camp);
	}



	public void setCourseList(String bootcampName, List<Course> courses) {
		Bootcamp camp = bootcampRepository.findByBootcampName(bootcampName);
		String courseList = courses.toString();
		camp.setCourseList(courseList);
		bootcampRepository.save(camp);
	}
}
