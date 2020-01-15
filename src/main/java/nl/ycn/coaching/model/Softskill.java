package nl.ycn.coaching.model;

import javax.persistence.*;

@Entity
public class Softskill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int softskillId;

    @Column(name = "Softskill")
    private String name;

    @Column(name = "Beschrijving")
    private String description;

    public Softskill(){}

    public Softskill(String name, String description){
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return softskillId;
    }

    public void setId(int id) {
        this.softskillId = id;
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
}
