package nl.ycn.coaching.services;

import nl.ycn.coaching.database.AppUserRepository;
import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.Softskill;
import nl.ycn.coaching.model.users.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService {

    @Autowired
    private BootcampRepository bootcampRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private SoftskillRepository softskillRepository;
    @Autowired
    private CourseRepository courseRepository;


    public void addSoftskill(
            String name,
            String description) {
        Softskill softskill = new Softskill(name, description);
        softskillRepository.save(softskill);
    }

    //retreive top 'length' bootcamps from the repository and return a list with the top 'length' bootcamps.
    public List<Bootcamp> getTopActiveBootcamps(int length){
        Page<Bootcamp> topBootcamps = bootcampRepository.findAllByStatus(true, PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

    public List<Bootcamp> getTopFinishedBootcamps(int length){
        Page<Bootcamp> topBootcamps = bootcampRepository.findAllByStatus(false, PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

    public List<AppUser> getTrainees(String role) {
        return appUserRepository.findByRole(role);
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();

    }

    public void addCourse(
            String name,
            String description) {
        Course course = new Course(name, description);
        courseRepository.save(course);
    }

    //retreive top 'length' bootcamps from the repository and return a list with the top 'length' bootcamps.
    public List<Bootcamp> getTopBootcamps(int length) {
        Page<Bootcamp> topBootcamps = bootcampRepository.findAll(PageRequest.of(0, length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

    public List<Softskill> getSoftskillsForSkillspage() {
        return softskillRepository.findAll();

    }

    public Softskill getSoftskillsForSkillspageByName(String name) {
        return softskillRepository.findByName(name);
    }

    public Softskill getSoftskillsForSkillspageById(int id){
        return softskillRepository.findBySoftskillId(id);
    }

    public List<Course> getCoursesForSkillspage() {
        return courseRepository.findAll();
    }

    public Course getCourseForSkillspageByName(String name) {
        return courseRepository.findByCoursename(name);
    }

    public Course getCourseForSkillspageById(int id){
        return courseRepository.findByCourseId(id);
    }

    public void editCourse(int id, String coursename,
                           String coursedescription){
        Course editCourse = courseRepository.findByCourseId(id);
        editCourse.setCoursename(coursename);
        editCourse.setCoursedesciption(coursedescription);
        courseRepository.save(editCourse);
    }

    public void editSoftskill(int id, String name,
                              String description){
        Softskill editSoftskill = softskillRepository.findBySoftskillId(id);
        editSoftskill.setName(name);
        editSoftskill.setDescription(description);
        softskillRepository.save(editSoftskill);
    }

}

