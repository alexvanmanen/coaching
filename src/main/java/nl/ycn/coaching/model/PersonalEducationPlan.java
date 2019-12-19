package nl.ycn.coaching.model;

import java.util.List;

public class PersonalEducationPlan {

    public PersonalEducationPlan(){}

    private List<PersonalSoftskill> personalSoftskillList;

    private List<PersonalHardskill> personalHardskillList;

    private String recommendations;

    public List<PersonalHardskill> getPersonalHardskillList(){
        return personalHardskillList;
    }


}
