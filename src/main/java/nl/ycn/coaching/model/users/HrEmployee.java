package nl.ycn.coaching.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class HrEmployee extends AppUser {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public HrEmployee () {
	}
	
	public HrEmployee (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, Date dateofbirth, String zipcode, String street, String streetNr, String city, String country, String telephonenumber) {
		super (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
	}
}
