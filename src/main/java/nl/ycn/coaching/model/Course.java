package nl.ycn.coaching.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private String name;

    @Column
    private String description;
    
    public Course() {}
    
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
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
    
    public String getDescription () {
        return description;
    }
    
    public void setDescription (String desciption) {
        this.description = description;
    }
}
