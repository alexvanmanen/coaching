package nl.ycn.coaching.services;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private BootcampService bootcampService;

	@Autowired
	private BootcampRepository bootcampRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUsername(username);
		UserDetails userDetails =
				org.springframework.security.core.userdetails.User
						.builder()
						.username(username)
						.password(user.getPassword())
						.roles(user.getRole())
						.build();

		return userDetails;
	}

	public void registerUser(
			String username,
			String firstname,
			String lastname,
			String email,
			String password,
			String roles,
			boolean enabled,
			boolean activated) {
		AppUser user = appUserRepository.findByUsername(username);
		if (user == null) {
			AppUser newUser = new AppUser(
					username,
					firstname,
					lastname,
					email,
					password,
					roles,
					enabled,
					activated);
			appUserRepository.save(newUser);
		} else {
			System.out.print("username already taken");
		}
	}

	//overloaded method registerUser
	public void registerUser(
				String username,
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
				String streetNr,
				String city,
				String country,
				String telephonenumber,
				String bootcamp) {
		AppUser user = appUserRepository.findByUsername(username);
		if (user == null){
			switch (role) {
				case "TRAINEE":
					AppUser newUser = new Trainee(username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber, bootcampRepository.findByBootcampName(bootcamp.toLowerCase()));
					appUserRepository.save (newUser);
					break;
				case "HREMPLOYEE":
					newUser = new HrEmployee (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
					appUserRepository.save (newUser);
					break;
				case "MANAGER":
					newUser = new Manager (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
					appUserRepository.save (newUser);
					break;
				case "TALENTMANAGER":
					newUser = new TalentManager (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
					appUserRepository.save (newUser);
					break;
				case "ADMIN":
					newUser = new AppUser (username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
					appUserRepository.save (newUser);
					break;
					}
		} else {
			System.out.print("username already taken");
		}
	}

	public AppUser getUser(String userName) {
		return appUserRepository.findByUsername(userName);
	}

	public AppUser getActiveUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		UserDetails details = (UserDetails) authentication.getPrincipal();
		AppUser user = getUser(details.getUsername());
		return user;
	}

	public List<AppUser> getAppUsersByRole(String role) {
		List<AppUser> listAppUsersByRole = appUserRepository.findByRole(role);
		return listAppUsersByRole;
	}


	//Changes the current user's password to a new given password
	public void changePassword(String new_password) {

		//Password encoder
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		//Get current user entity
		String username = getActiveUser().getUsername();
		AppUser updated_appUser = appUserRepository.findByUsername(username);

		//Update current user's password
		updated_appUser.setPassword(encoder.encode(new_password));

		//Save to repository
		appUserRepository.save(updated_appUser);
	}

	public void updateAppUser(String username,
							  String firstname,
							  String lastname,
							  String email,
							  String password,
							  boolean enabled,
							  boolean activated,
							  Date dateofbirth,
							  String zipcode,
							  String street,
							  String streetNr,
							  String city,
							  String country,
							  String telephonenr,
							  String bootcamp) {
		AppUser updateUser = appUserRepository.findByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (updateUser.getPassword()!=null && !updateUser.getPassword().equals(password)){
			updateUser.setPassword(encoder.encode(password));
		}

		updateUser.setFirstName(firstname);
		updateUser.setLastName(lastname);
		updateUser.setEmail(email);
		updateUser.setDateofbirth(dateofbirth);
		updateUser.setStreet(street);
		updateUser.setStreetNr(streetNr);
		updateUser.setZipcode(zipcode);
		updateUser.setCity(city);
		updateUser.setCountry(country);
		updateUser.setTelephonenumber(telephonenr);
		updateUser.setEnabled(enabled);
		updateUser.setActivated(activated);
		if (getUser(username).getRole().equals("TRAINEE")){
			Trainee updateTrainee = (Trainee) updateUser;
			updateTrainee.setBootcamp(bootcampService.updateBootcamp(bootcamp));
		}
		appUserRepository.save(updateUser);
	}

}
