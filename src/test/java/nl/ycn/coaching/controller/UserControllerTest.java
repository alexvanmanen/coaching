package nl.ycn.coaching.controller;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import nl.ycn.coaching.configurations.AppSecurityConfiguration;
import nl.ycn.coaching.controller.UserController;
import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
public class UserControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AppUserService appUserService;

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void getLastNameShouldReturnLastNameFromAppUserService() throws Exception {
//
//
//        when(appUserService.getUser("Klaas")).thenReturn(new AppUser("Klaas","Klaas", "Jansen", "klaas@hotmail.com", "hallo", "ADMIN,USER,GUEST"));
//        this.mockMvc.perform(get("/getLastName/Klaas")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Jansen")));
//
//    }
}
