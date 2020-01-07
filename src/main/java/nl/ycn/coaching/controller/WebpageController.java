package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WebpageController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	public WebpageController() {

	}

	private static final Logger logger =
			LoggerFactory.getLogger(WebpageController.class);

	@GetMapping({"/", "/home", "/index"})
	public String home(Device device) {
		if (device.isMobile()) {
			logger.info("Hello mobile user!");
			return "/mobile/login";
		} else if (device.isTablet()) {
			logger.info("Hello tablet user!");
			return "/tablet/login";
		} else {
			logger.info("Hello desktop user!");
			return "login";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/logout";
	}

	//return logout page
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "/logout";
	}

	@GetMapping("/open/**")
	public String open() {
		return "open";
	}


	@GetMapping("/admin/**")
	public String admin() {
		return "admin";
	}


	@GetMapping({"redirectLogin", "/dashboard"})
	public String getDashBoard() {

		try {
			AppUser user = appUserService.getActiveUser();
			String role = user.getRole();
			return "redirect:/" + role.toLowerCase() + "/dashboard";
		} catch (Exception e) {
			return "login";
		}
	}

	@PostMapping("/login")
	public String validateLogin() {
		return "/dashboardpages/dashboardpage";
	}
}
