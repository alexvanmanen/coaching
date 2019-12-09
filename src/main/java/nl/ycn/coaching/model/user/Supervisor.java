package nl.ycn.coaching.model.user;

import javax.persistence.Entity;

@Entity
public class Supervisor extends User {
    @Override
    public String getRole() {
        return "Supervisor";
    }
}
