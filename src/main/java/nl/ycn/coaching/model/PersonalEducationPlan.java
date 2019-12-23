package nl.ycn.coaching.model;

import nl.ycn.coaching.database.HardskillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonalEducationPlan {

    @Autowired
    private HardskillRepository hardskillRepository;

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

    /* Fill the personal Soft- and Hardskill lists given the username */
    public void fillPersonalLists(String username) {
        /*TODO add Softskills too*/

        List<PersonalHardskill> databasePersonalHardskills = hardskillRepository.findAll();

        for (PersonalHardskill entry : databasePersonalHardskills) {
            /*TODO change getName to getUsername*/
            if (entry.getName().equals(username)) {
                addHardskill(entry);
            }
        }
    }

    public void addHardskill(PersonalHardskill skill) {
        this.personalHardskillList.add(skill);
    }

    public void addSoftskill(PersonalSoftskill skill) {
        this.personalSoftskillList.add(skill);
    }

}
