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

    @ManyToOne
    @JoinColumn
    private Person person;


    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public Person getPerson() {
        return person;
    }
}
