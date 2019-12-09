package nl.ycn.coaching;

import nl.ycn.coaching.model.BankAccount;
import nl.ycn.coaching.model.user.Coach;
import nl.ycn.coaching.model.user.Trainee;
import nl.ycn.coaching.model.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CoachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoachingApplication.class, args);
    }

}
