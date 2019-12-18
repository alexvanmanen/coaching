package demo.spring.loginapp.web;

import demo.spring.loginapp.database.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebpageController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping({"/", "/home", "/index"})
    public String homepage(Device device) {
        if(device.isMobile())
            return "/mobile/home";

        if(device.isTablet())
            return "/tablet/home";

        return "home";
    }

    @GetMapping("/open/**")
    public String open() {
        return "open";
    }

    @GetMapping("/user/**")
    public String user() {
        return "user";
    }

    @GetMapping("/admin/**")
    public String admin() {
        return "admin";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String register(
        String username,
        String firstname,
        String lastname,
        String password,
        String role) {

        System.out.println(username);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(password);
        System.out.println(role);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUserService.registerUser(
            username,
            firstname,
            lastname,
            encoder.encode(password),
            role
        );

        return "home";
    }
}
