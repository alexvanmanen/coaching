package nl.ycn.coaching.model.users;

import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.model.*;
import org.springframework.beans.factory.annotation.Autowired;

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

	public Trainee(String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, Date dateofbirth, String zipcode, String street, String streetNr, String city, String country, String telephonenumber, Bootcamp bootcamp) {
		super(username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
		this.bootcamp = bootcamp;
	}
	
	public Trainee (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated) {
		super (username, firstName, lastName, email, password, role, enabled, activated);
	}
	
	public void setBootcamp(Bootcamp bootcamp) {
		this.bootcamp = bootcamp;
	}
	
	public Bootcamp getBootcamp () {
		return bootcamp;
	}


}
