package nl.ycn.coaching.model;

import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.database.HardskillRepository;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonalEducationPlan {

    private List<Softskill> personalSoftskillList;
    private List<PersonalHardskill> personalHardskillList;
    private String recommendations;

    public PersonalEducationPlan(){

        this.personalSoftskillList = new ArrayList<Softskill>();
        this.personalHardskillList = new ArrayList<PersonalHardskill>();
        this.recommendations = "";

    }

    public List<Softskill> getPersonalSoftskillList() {
        return personalSoftskillList;
    }

    public void setPersonalSoftskillList(List<Softskill> personalSoftskillList) {
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
