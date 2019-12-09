package nl.ycn.coaching.model.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coach extends User {

    @OneToMany
    @JoinColumn
    List<Trainee> traineeList;

    @Override
    public String getRole() {
        return "Coach";
    }
}
