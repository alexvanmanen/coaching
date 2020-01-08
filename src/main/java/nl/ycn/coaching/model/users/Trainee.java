package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="trainees")
@DiscriminatorValue (value = "trainee")
public class Trainee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BOOTCAMP_ID")
	private Bootcamp bootcamp;
	
	@OneToOne
	@JoinColumn(name ="userId", insertable = false, updatable = false)
	private AppUser user;
	
	public Trainee(){}
	
	public Trainee(AppUser user, Bootcamp bootcamp) {
		this.user = user;
		this.bootcamp = bootcamp;
	}

	public void addCertificate(){}

	public void createPersonalEducationPlan(){
		PersonalEducationPlan plan = new PersonalEducationPlan();
	}

	public void send360Request(){}





}
