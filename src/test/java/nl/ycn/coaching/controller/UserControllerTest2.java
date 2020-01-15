package nl.ycn.coaching.controller;


import nl.ycn.coaching.services.AppUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
public class UserControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //when(appUserService.getUser("Klaas")).thenReturn(new AppUser("Klaas","Klaas", "Klaasen", "klaas@hotmail.com", "hallo", "ADMIN,USER,GUEST"));
        this.mockMvc.perform(get("/getLastName/Klaas")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("jansen")));
    }
}
