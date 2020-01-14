package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.users.AppUser;
import nl.ycn.coaching.model.users.Trainee;
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
	private TraineeRepository traineeRepository;

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
	
	public void addBootcampToTrainee(String traineeFirstName, String bootcampName) {
		Bootcamp bootcamp = bootcampRepository.findByBootcampName (bootcampName);
		Trainee trainee = traineeRepository.findByFirstName (traineeFirstName);
		trainee.setBootcamp (bootcamp);
		appUserRepository.save (trainee);
		//		AppUser user = appUserRepository.findById (traineeFirstName);
//		Trainee trainee = new Trainee (user, bootcamp);
//		traineeRepository.save (trainee);
	}
}
