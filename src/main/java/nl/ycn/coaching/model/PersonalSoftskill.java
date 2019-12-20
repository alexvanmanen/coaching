package nl.ycn.coaching.model;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

public class PersonalSoftskill {

    private int id;

    private Softskill softskill;
    private List<DateMessage> dateMessageList;

    private String report;

    public void addDateMessage() {

    }

}
