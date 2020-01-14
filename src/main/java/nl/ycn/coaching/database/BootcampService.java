package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
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
}
