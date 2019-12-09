package nl.ycn.coaching.model.user;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class User {
    @Id
    private Integer id;
    private String name;

    public Integer getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public abstract String getRole();
}
