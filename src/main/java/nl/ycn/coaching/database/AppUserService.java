package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

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
		if (user == null){
			AppUser newUser = new AppUser(username, firstname, lastname, email, password, roles, enabled, activated);
			appUserRepository.save(newUser);
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

	public List<AppUser> getAppUsersByRole(String role){
		List<AppUser> listAppUsersByRole = appUserRepository.findByRole(role);
		return listAppUsersByRole;
	}

	//Changes the current user's password to a new given password
	public void changePassword(String new_password){

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

}
