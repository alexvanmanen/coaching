package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class UserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    public UserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/getLastName/{username}")
    public AppUser getLastName(@PathVariable String username) {
//        AppUser appUser = new AppUser();
//        appUser.setLastName("janssen");
        return appUserRepository.findByUsername(username);
//        return appUser;
        //return appUserService.getUser(username).getLastName();
    }


    @PostMapping("/adduser")
    public AppUser addUser(@RequestBody AppUser appUser){
        return appUserRepository.save(appUser);
    }

}

