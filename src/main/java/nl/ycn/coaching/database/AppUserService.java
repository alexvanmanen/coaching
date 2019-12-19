package nl.ycn.coaching.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
		AppUser appUser = appUserRepository.findByUsername(username);
		UserDetails userDetails =
				User
				.builder()
				.username(username)
				.password(appUser.getPassword())
				.roles(appUser.getRoles())
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

		AppUser appUser = new AppUser(username, firstname, lastname, email, password, roles);
		appUserRepository.save(appUser);
	}
}
