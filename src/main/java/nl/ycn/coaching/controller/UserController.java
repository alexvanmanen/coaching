package nl.ycn.coaching.controller;

import nl.ycn.coaching.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class UserController {


    AppUserService appUserService;

    @Autowired
    public UserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @GetMapping("/getLastName/{username}")
    public String getLastName(@PathVariable String username) {
        return "jansen" ;
        //return appUserService.getUser(username).getLastName();
    }

}

