package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PersonalHardskill {

    @Id
    private int id;

    private String name;
    private String description;
    private String report;
    private String state;
    private Date start;
    private Date end;

    public PersonalHardskill(String name, String description, Date start, Date end) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }



}
