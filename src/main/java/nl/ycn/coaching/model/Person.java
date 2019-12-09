package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Person {

    @Id
    private Integer id;
    private String name;
    private Date dateOfBirth;

    public Person(int id, String name, java.sql.Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

//    @OneToMany
//    private List<Address> addresses;
}
