package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.web.bind.annotation.RestController
public class UserController {

    @Autowired
    AppUserService appUserService;


//    @GetMapping("/getLastname/${username}")
//    public String getLastName(@PathVariable String username) {
//
//        return appUserService.getUser(username).getLastName();
//    }

}

