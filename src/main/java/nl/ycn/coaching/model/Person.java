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

    public Person(){

    }

    public Person(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getVoornaam() {
        return name;
    }

    public Date getGeboortedatum(){
        return dateOfBirth;
    }

    public String getget(){
        return id+" "+ name;
    }

//    @OneToMany
//    private List<Address> addresses;
}
