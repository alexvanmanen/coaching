package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.PersonalEducationPlan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class TalentManager extends AppUser {
	
	@Id
	@GeneratedValue
	private Long id;
	
//	public List<Trainee> traineeList;
	
	public TalentManager () {
	}
	
	public TalentManager (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated) {
		super (username, firstName, lastName, email, password, role, enabled, activated);
	}
	
	public void makeAppointment(Date date, Trainee trainee) {}
	
	public void getDashboard(Trainee trainee) {}
	
	public void makeRecommendations (PersonalEducationPlan personalEducationPlan) {}
}
