package nl.ycn.coaching.model.user;

import javax.persistence.*;

@Entity
public class Trainee extends User {

    @ManyToOne
    @JoinColumn
    public Coach coach;
    public String address;
    public String city;


    public String getRole() {
        return "Trainee";
    }
}
