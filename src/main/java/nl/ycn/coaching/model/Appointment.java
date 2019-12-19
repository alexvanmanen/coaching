package nl.ycn.coaching.model;

import nl.ycn.coaching.model.users.AppUser;

import java.util.Date;

public class Appointment {
	
	public AppUser sender;
	public AppUser recipient;
	public Date time;
	public String description;
	
	public void makeAppointment() {}
}
