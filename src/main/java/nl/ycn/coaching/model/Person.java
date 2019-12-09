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

//    @OneToMany
//    private List<Address> addresses;
}
