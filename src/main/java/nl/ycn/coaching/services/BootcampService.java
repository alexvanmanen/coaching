package nl.ycn.coaching.services;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.users.AppUser;
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
	private AppUserRepository appUserRepository;
	

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
	
	public List<AppUser> fillTraineeList() {
		List<AppUser> traineeList = new ArrayList<AppUser>();
		List<AppUser> allUsers = appUserRepository.findAll();
		for (AppUser user : allUsers) {
			if (user.getRole ().equals("TRAINEE")) {
				traineeList.add(user);
			}
		}
		return allUsers;
	}
}
