package nl.ycn.coaching.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Manager extends AppUser {
	
	@Id
	@GeneratedValue
	private Long id;
	
//	List<Trainee> trainees;
	
	public Manager () {
	}
	
	public Manager (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated) {
		super (username, firstName, lastName, email, password, role, enabled, activated);
	}
	
	public void getDashboard (Trainee trainee) {
	}
	
	public void createCalendar () {
	}
	
	public void makeAppointment (Date date, Trainee trainee) {
	}
	
	public void getProgress (Trainee trainee) {
	}
}
