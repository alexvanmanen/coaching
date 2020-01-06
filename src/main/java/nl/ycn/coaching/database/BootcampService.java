package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootcampService {

	private BootcampRepository bootcampRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	public void setBootcampRepository(BootcampRepository bootcampRepository){
		this.bootcampRepository = bootcampRepository;
	}

	public void addBootcamp(
			String bootcampName,
			String courseList){
		Bootcamp bootcamp = new Bootcamp (bootcampName, courseList);
		bootcampRepository.save (bootcamp);
	}
}
