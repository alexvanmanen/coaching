package nl.ycn.coaching.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
