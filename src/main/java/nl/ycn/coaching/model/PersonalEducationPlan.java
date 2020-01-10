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

    public List<PersonalSoftskill> getPersonalSoftskillList() {
        return personalSoftskillList;
    }

    public void setPersonalSoftskillList(List<PersonalSoftskill> personalSoftskillList) {
        this.personalSoftskillList = personalSoftskillList;
    }

    public List<PersonalHardskill> getPersonalHardskillList() {
        return personalHardskillList;
    }

    public void setPersonalHardskillList(List<PersonalHardskill> personalHardskillList) {
        this.personalHardskillList = personalHardskillList;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
