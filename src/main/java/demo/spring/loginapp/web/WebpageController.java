package demo.spring.loginapp.web;

import demo.spring.loginapp.database.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebpageController {


    @Autowired
    private AppUserService appUserService;

    public WebpageController(){}

    private static final Logger logger =
            LoggerFactory.getLogger(WebpageController.class);

    @GetMapping({"/","/home", "/index"})
    public String home(Device device) {
        if (device.isMobile()) {
            logger.info("Hello mobile user!");
            return "/mobile/home";
        } else if (device.isTablet()) {
            logger.info("Hello tablet user!");
            return "/tablet/home";
        } else {
            logger.info("Hello desktop user!");
            return "home";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "login";
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
    public String register(){
        return "register";
    }

    @GetMapping("dashboardpage")
    public String getDashBoard(){
        return "/dashboardpages/dashboardpage";
    }


    @GetMapping("hardskillspage")
    public String getHardSkillsPage(Model model){
        //model.addAttribute(DashController.getHardskillsList());
        return "/dashboardpages/hardskillspage";
    }

    @GetMapping("softskillspage")
    public String getSoftSkillsPage(){
        return "/dashboardpages/softskillspage";
    }

    @GetMapping("agendapage")
    public String getAgendaPage(){
        return "/dashboardpages/agendapage";
    }

    @GetMapping("gegevenspage")
    public String getGegevensPage(){
        return "/dashboardpages/gegevenspage";
    }

    @PostMapping("login")
    public String validateLogin(){
        return "/dashboardpages/dashboardpage";
    }

    @PostMapping("hardskillspage")
    public String goToHardSkills(){
        return "/dashboardpages/hardskillspage";
    }

    @PostMapping("gegevenspage")
    public String goToGegevens(){
        return "/dashboardpages/gegevenspage";
    }

    @PostMapping("softskillspage")
    public String goToSoftSkills(){
        return "/dashboardpages/softskillspage";
    }

    @PostMapping("agendapage")
    public String goToAgenda(){
        return "/dashboardpages/agendapage";
    }

    @PostMapping("dashboard")
    public String goToDashoard(){
        return "/dashboardpages/dashboardpage";
    }

    @PostMapping("/register")
    public String register(String username, String firstname, String lastname, String email, String password, String roles){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUserService.registerUser(username,  firstname, lastname, email, encoder.encode(password), roles);

        return "/dashboardpages/dashboardpage";
    }
}
