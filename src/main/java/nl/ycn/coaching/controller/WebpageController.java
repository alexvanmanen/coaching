package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserRepository;
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

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class WebpageController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

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
            return "/login";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/logout";
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session){
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


    @GetMapping({"redirectLogin","/dashboard"})
    public String getDashBoard() {

        try {
            AppUser user = appUserService.getActiveUser();

            //If it's their first time logging in (thus not activated)
            //redirect to the change password screen
            if (!(user.isActivated())) {
                return "/accountsettings";
            }
          
            String role = user.getRole();
            return "/" +role.toLowerCase()+"/dashboard";

        } catch (Exception e) {
            return "login";
        }
    }

    @GetMapping("/coursespage")
    public String getHardSkillsPage(Model model){
        //model.addAttribute(DashController.getHardskillsList());
        return "/dashboardpages/coursespage";
    }

    @GetMapping("/agendapage")
    public String getAgendaPage(){
        return "/dashboardpages/agendapage";
    }

    @GetMapping("/contactdetails")
    public String getcontactdetailPage(){
        return "/dashboardpages/contactdetails";
    }

    @PostMapping("/login")
    public String validateLogin(){

        return "/dashboardpages/dashboardpage";
    }

    @PostMapping("/coursespage")
    public String goToHardSkills(){
        return "/dashboardpages/coursespage";
    }

    @PostMapping("/contactdetails")
    public String goTocontactdetails(){
        return "/dashboardpages/contactdetails";
    }

    @PostMapping("/agendapage")
    public String goToAgenda(){
        return "/dashboardpages/agendapage";
    }

    @PostMapping("/dashboard")
    public String goToDashoard(){
        return "/dashboardpages/dashboardpage";
    }

    @PostMapping("/register")
    public String register(String username, String firstname, String lastname, String email, String password, String roles){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUserService.registerUser(username,  firstname, lastname, email, encoder.encode(password), roles, false, false);

        return "/dashboardpages/dashboardpage";
    }

    @GetMapping("/accountsettings")
    public String accountsettings() {

        return "/accountsettings";
    }

    @PostMapping("/changepassword")
    public String changepassword(String new_password, String confirm_password) {

        //If new password equals confirmation password then update the database
        if (new_password.equals(confirm_password)) {
            appUserService.changePassword(new_password);

            //If it's the users first time, then set their account
            //to activated
            AppUser user = appUserService.getActiveUser();
            if (!user.isActivated()) {
                user.setActivated(true);
                appUserRepository.save(user);
            }

            return "redirect:/redirectLogin";
        }

        return "redirect:/accountsettings";
    }
}
