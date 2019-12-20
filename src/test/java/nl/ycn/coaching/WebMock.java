package nl.ycn.coaching;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import nl.ycn.coaching.controller.UserController;
import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.model.users.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class WebMock {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.getUser("Klaas")).thenReturn(new AppUser("Klaas","Klaas", "Jansen", "klaas@hotmail.com", "hallo", "ADMIN,USER,GUEST"));
        this.mockMvc.perform(get("/getLastname/Klaas")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Jansen")));
    }
}
