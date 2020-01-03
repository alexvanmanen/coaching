package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class PersonalHardskill {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String report;
    private String state;
    private Date start;
    private Date end;
    private String username;

    public PersonalHardskill() {}

    public PersonalHardskill(String name, String description, String report, String state, Date start, Date end, String username) {
        this.name = name;
        this.description = description;
        this.report = report;
        this.state = state;
        this.start = start;
        this.end = end;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
