package nl.ycn.coaching.model;


import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column
    private String coursename;

    @Column(length = 512)
    private String coursedescription;

    public Course() {}

    public Course(String coursename, String coursedescription) {
        this.coursename = coursename;
        this.coursedescription = coursedescription;
    }

    public int getId () {
        return courseId;
    }

    public void setId (int id) {
        this.courseId = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedesciption(String coursedescription) {
        this.coursedescription = coursedescription;
    }
}
