package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PersonalHardskill {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String report;
    private String state;
    private String start;
    private String end;
    private String username;

    public PersonalHardskill() {}

    public PersonalHardskill(String name, String description, String state, String start, String end, String username) {
        this.name = name;
        this.description = description;
        this.report = null;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
