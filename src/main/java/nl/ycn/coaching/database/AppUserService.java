package nl.ycn.coaching.database;

import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
				.roles(user.getRoles())
				.build();

		return userDetails;
	}



	public void registerUser(
			String username,
			String firstname,
			String lastname,
			String email,
			String password,
			String roles) {

		AppUser user = new AppUser(username, firstname, lastname, email, password, roles);
		appUserRepository.save(user);
	}
}
