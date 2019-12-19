package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.PersonalEducationPlan;

import java.util.Date;
import java.util.List;

public class TalentManager extends AppUser {
	
	public List<Trainee> traineeList;
	
	public void makeAppointment(Date date, Trainee trainee) {}
	
	public void getDashboard(Trainee trainee) {}
	
	public void makeRecommendations (PersonalEducationPlan personalEducationPlan) {}
}
