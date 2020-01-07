package nl.ycn.coaching.database;

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
