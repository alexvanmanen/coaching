package nl.ycn.coaching.model.users;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="users")
public class AppUser {

	@Id
	@GeneratedValue
	private long id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="email")
	private String email;

	@Column(name="enabled")
	private boolean enabled;

	@Column(name="activated")
	private boolean activated;

	//Contactgegevens
	@Column(name="dateofbirth")
	private Date dateofbirth;

	@Column(name="zipcode")
	private String zipcode;

	@Column(name="street")
	private String street;

	@Column(name="streetnumber")
	private int streetnumber;

	@Column(name="city")
	private String city;

	@Column(name="country")
	private String country;

	@Column(name="telephonenumber")
	private String telephonenumber;

//	@Column(name="contactdetails")
//	private ContactDetails details;
//
//	@OneToMany
//	private List<Notifications> notifications;

	//private Calendar calendar;

	public AppUser() {
	}

	public AppUser(String username,
				   String firstName,
				   String lastName,
				   String email,
				   String password,
				   String role,
				   boolean enabled,
				   boolean activated,
				   Date dateofbirth,
				   String zipcode,
				   String street,
				   int streetnumber,
				   String city,
				   String country,
				   String telephonenumber) {

			this.username = username;
			this.password = password;
			this.role = role;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.enabled = enabled;
			this.activated = activated;
			this.dateofbirth = dateofbirth;
			this.zipcode = zipcode;
			this.street = street;
			this.streetnumber = streetnumber;
			this.city = city;
			this.country = country;
			this.telephonenumber = telephonenumber;

		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getRole() {
		//String roles = this.roles.split(",");
		return this.role;
	}

	public void setRoles(String role) {
		this.role = role;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(int streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephonenumber() {
		return telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	public void login(){

	}

	public void logout(){

	}
}
