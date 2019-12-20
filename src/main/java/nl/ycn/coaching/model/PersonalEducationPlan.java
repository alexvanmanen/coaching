package nl.ycn.coaching.model;

import java.util.ArrayList;
import java.util.List;

public class PersonalEducationPlan {

    private List<PersonalSoftskill> personalSoftskillList;
    private List<PersonalHardskill> personalHardskillList;
    private String recommendations;

    public PersonalEducationPlan(){

        this.personalSoftskillList = new ArrayList<PersonalSoftskill>();
        this.personalHardskillList = new ArrayList<PersonalHardskill>();
        this.recommendations = "";

    }

    public List<PersonalHardskill> getPersonalHardskillList(){
        return personalHardskillList;
    }


    public void addHardskill(PersonalHardskill skill) {
        this.personalHardskillList.add(skill);
    }
}
