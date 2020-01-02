package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootcampService {
	
	@Autowired
	private BootcampRepository bootcampRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void addBootcamp(
			String bootcampName,
			String courseList){
		Bootcamp bootcamp = new Bootcamp (bootcampName, courseList);
		bootcampRepository.save (bootcamp);
	}
}
