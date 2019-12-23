package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebpageController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    public WebpageController(){

    }

    private static final Logger logger =
            LoggerFactory.getLogger(WebpageController.class);

    @GetMapping({"/","/home", "/index"})
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
    public String login(){

        return "login";
    }

    @GetMapping("/open/**")
    public String open() {
        return "open";
    }

    @GetMapping("/user/**")
    public String user(Model model) {
        model.addAttribute("username", appUserService.getUser("wempie").getUsername());
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

    @GetMapping({"redirectLogin","/dashboardpage"})
    public String getDashBoard(){
    AppUser activeUser = new AppUser();
    activeUser = appUserService.getUser("alex");
    switch(activeUser.getRole()){
        case "ADMIN":
            return "admin/dashboard";
        case "TRAINEE":
            return "trainee/dashboard";
        case "MANAGER":
            return "manager/dashboard";
        case "HREMPLOYEE":
            return "hremployee/dashboard";
        case "TALENTMANAGER":
            return "talentmanager/dashboard";
        default:
            return "dashboardpages/dashboardpage";
        }

    }

    @GetMapping("coursespage")
    public String getHardSkillsPage(Model model){
        //model.addAttribute(DashController.getHardskillsList());
        return "/dashboardpages/coursespage";
    }

    @GetMapping("agendapage")
    public String getAgendaPage(){
        return "/dashboardpages/agendapage";
    }

    @GetMapping("contactdetails")
    public String getcontactdetailPage(){
        return "/dashboardpages/contactdetails";
    }

    @PostMapping("login")
    public String validateLogin(){
        return "/dashboardpages/dashboardpage";
    }

    @PostMapping("coursespage")
    public String goToHardSkills(){
        return "/dashboardpages/coursespage";
    }

    @PostMapping("contactdetails")
    public String goTocontactdetails(){
        return "/dashboardpages/contactdetails";
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
