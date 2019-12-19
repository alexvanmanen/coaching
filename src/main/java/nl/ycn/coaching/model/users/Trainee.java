package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.*;

import java.util.List;

public class Trainee extends AppUser {

	private PersonalEducationPlan pepPlan;
	private List<Certificate> certificates;
	private Bootcamp bootcamp;
	private Team team;
	private List<Test360> tests360;

	public Trainee(){
		PersonalEducationPlan plan = new PersonalEducationPlan();
		this.pepPlan = plan;

	}

	public void addCertificate(){}

	public void createPersonalEducationPlan(){
		PersonalEducationPlan plan = new PersonalEducationPlan();
	}

	public void send360Request(){}

	public PersonalEducationPlan getPepPlan(){
		return this.pepPlan;
	}




}
