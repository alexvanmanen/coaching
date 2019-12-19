package nl.ycn.coaching.model;

import java.util.List;

public class PersonalEducationPlan {

    private List<PersonalSoftskill> personalSoftskillList;
    private List<PersonalHardskill> personalHardskillList;
    private String recommendations;

    public PersonalEducationPlan(){}

    public List<PersonalHardskill> getPersonalHardskillList(){
        return personalHardskillList;
    }


    public void addHardskill(PersonalHardskill skill) {
        this.personalHardskillList.add(skill);
    }
}
