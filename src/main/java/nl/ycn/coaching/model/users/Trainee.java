package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Trainee extends AppUser{
	
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
	
	public Trainee (Bootcamp bootcamp, AppUser user) {
		this.bootcamp = bootcamp;
		this.user = user;
	}
	
	public Trainee (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, Date dateofbirth, String zipcode, String street, int streetnumber, String city, String country, String telephonenumber) {
		super (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetnumber, city, country, telephonenumber);
	}
	
	public Trainee (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, Date dateofbirth, String zipcode, String street, int streetnumber, String city, String country, String telephonenumber, Bootcamp bootcamp, AppUser user) {
		super (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetnumber, city, country, telephonenumber);
		this.bootcamp = bootcamp;
		this.user = user;
	}
	
	public void setBootcamp(Bootcamp bootcamp) {
		this.bootcamp = bootcamp;
	}
	
	public Bootcamp getBootcamp () {
		return bootcamp;
	}
	
	public AppUser getUser () {
		return user;
	}
	
	public void setUser (AppUser user) {
		this.user = user;
	}
	
	public void addCertificate(){}

	public void createPersonalEducationPlan(){
		PersonalEducationPlan plan = new PersonalEducationPlan();
	}

	public void send360Request(){}





}
