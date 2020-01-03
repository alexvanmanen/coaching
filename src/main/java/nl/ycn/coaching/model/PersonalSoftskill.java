package nl.ycn.coaching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalSoftskill {
    
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
    
    @Column
    private String description;
    
    @Column
    private String report;

    @Column
    private String username;

    public PersonalSoftskill() {}
    
    public PersonalSoftskill(String name, String description, String report, String username) {
        this.name = name;
        this.description = description;
        this.report = report;
        this.username = username;
    }
    public void editReport() {

    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getReport () {
        return report;
    }
    
    public void setReport (String report) {
        this.report = report;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setDescription (String description) {
        this.description = description;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
