package nl.ycn.coaching.model.users;

import nl.ycn.coaching.model.Calendar;
import nl.ycn.coaching.model.ContactDetails;
import nl.ycn.coaching.model.Notifications;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class AppUser {

	@Id
	@GeneratedValue
	private long Id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private boolean enabled;

	@Column(name="roles")
	private String roles;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="email")
	private String email;

//	@Column(name="contactdetails")
//	private ContactDetails details;
//
//	@OneToMany
//	private List<Notifications> notifications;

	//private Calendar calendar;

	public AppUser() {
	}

	public AppUser(String username, String firstName, String lastName, String email, String password, String roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String[] getRoles() {
		String[] roles = this.roles.split(",");
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void login(){

	}

	public void logout(){

	}
}
