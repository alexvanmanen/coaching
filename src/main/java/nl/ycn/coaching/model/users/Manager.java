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
	
	public Manager (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, java.sql.Date dateofbirth, String zipcode, String street, int streetnumber, String city, String country, String telephonenumber) {
		super (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetnumber, city, country, telephonenumber);
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
