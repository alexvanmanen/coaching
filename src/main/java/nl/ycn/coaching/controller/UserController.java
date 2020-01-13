package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class UserController {

    AppUserRepository appUserRepository;
    

    @Autowired
    public UserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/getLastName/{username}")
    public AppUser getLastName(@PathVariable String username) {
//        AppUser appuser = new AppUser();
//                appuser.setLastName ("jansen");
        return appUserRepository.findByUsername (username);
//        return  appuser;
        //return appUserService.getUser(username).getLastName();
    }
    
    @PostMapping("/addUser")
    public AppUser addUser(@RequestBody AppUser appUser) {
        return appUserRepository.save (appUser);
    }
}

