package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Softskill {

    @Id()
    private int id;

    private String name;
    private String description;
}
