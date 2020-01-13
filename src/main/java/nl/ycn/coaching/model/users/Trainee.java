package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="trainees")
@DiscriminatorValue (value = "trainee")
public class Trainee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private int userId;
	
	//private PersonalEducationPlan pepPlan;
	//private List<Certificate> certificates;
	@ManyToOne
	@JoinColumn(name = "BOOTCAMP_ID")
	private Bootcamp bootcamp;
	///private Team team;
	//private List<Test360> tests360;

	
	public int getUserId () {
		return userId;
	}
	
	public void setUserId (int userId) {
		this.userId = userId;
	}
	
	public AppUser getUser () {
		return user;
	}
	
	public void setUser (AppUser user) {
		this.user = user;
	}
	
	@OneToOne
	@JoinColumn(name ="userId", insertable = false, updatable = false)
	private AppUser user;

	public Trainee(){
		PersonalEducationPlan plan = new PersonalEducationPlan();
		//this.pepPlan = plan;

	}

	public Bootcamp getBootcamp() {
		return bootcamp;
	}

	public void setBootcamp(Bootcamp bootcamp) {
		this.bootcamp = bootcamp;
	}
}
