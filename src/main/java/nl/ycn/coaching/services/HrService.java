package nl.ycn.coaching.services;

import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.database.CourseRepository;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Course;
import nl.ycn.coaching.model.Softskill;
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
    private BootcampService bootcampService;
    @Autowired
    private SoftskillRepository softskillRepository;
    @Autowired
    private CourseRepository courseRepository;


    public void addSoftskill(
            String name,
            String description){
        Softskill softskill = new Softskill(name, description);
        softskillRepository.save(softskill);
    }

    public void addCourse(
            String name,
            String description) {
        Course course = new Course(name, description);
        courseRepository.save(course);
    }

    //retreive top 'length' bootcamps from the repository and return a list with the top 'length' bootcamps.
    public List<Bootcamp> getTopBootcamps(int length){
        Page<Bootcamp> topBootcamps = bootcampRepository.findAll(PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

    public List<Softskill> getSoftskillsForSkillspage() {
        List<Softskill> softskillslist = softskillRepository.findAll();
        return softskillslist;

    }

    public Softskill getSoftskillsForSkillspageByName(String name) {
        return softskillRepository.findByName (name);
    }

    public List<Course> getCoursesForSkillspage() {
        List<Course> courseslist = courseRepository.findAll();
        return courseslist;
    }

    public Course getCourseForSkillspageByName(String name){
        return courseRepository.findByName(name);
    }

}

