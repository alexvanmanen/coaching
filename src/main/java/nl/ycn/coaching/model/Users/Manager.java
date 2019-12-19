package nl.ycn.coaching.model.Users;


import nl.ycn.coaching.model.Trainee;
import nl.ycn.coaching.model.User;

import java.util.Date;
import java.util.List;

public class Manager extends User {
	
	List<Trainee> trainees;
	
	
	public void getDashboard (Trainee trainee) {
	}
	
	public void createCalendar () {
	}
	
	public void makeAppointment (Date date, Trainee trainee) {
	}
	
	public void getProgress (Trainee trainee) {
	}
}
