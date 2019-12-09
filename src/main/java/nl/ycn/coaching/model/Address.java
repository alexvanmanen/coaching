package nl.ycn.coaching.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private Integer id;
    private String street;
    private String streetNumber;
    private String zipcode;
    private String city;

//    @ManyToOne
//    @JoinColumn(name="person_id", nullable=false)
//    private Person person;

    @ManyToOne
    @JoinColumn
    private Person person;
}
