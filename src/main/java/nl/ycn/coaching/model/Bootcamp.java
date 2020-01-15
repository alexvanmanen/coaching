package nl.ycn.coaching.model;

import nl.ycn.coaching.model.users.Trainee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

@Entity
public class Bootcamp {

	@Id
	@GeneratedValue
	public int id;

	@Column
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bootcamp")
	private Set<Trainee> trainees = new HashSet<>();

	@Column
	public String bootcampName;

	@Column
	public String beginDate;

	@Column
	public String endDate;

	@Column
	public String courseList;

	@Column
	public boolean status;


	//default constructor
	public Bootcamp() {
	}

	//overloaded constructor
	public Bootcamp(String bootcampName, String courseList) {
		this.bootcampName = bootcampName;
		this.courseList = courseList;
		this.status = true;
	}

	public void getBootcamp() {
	}

	public String getName() {
		return bootcampName;
	}

	public void setBootcampName(String bootcampName){
		this.bootcampName = bootcampName;
	}

	public String getCourseList(){
		return courseList;
	}

	public void setCourseList(String courseList){
		this.courseList = courseList;
	}



	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setActive(boolean status) {
		this.status = status;
	}

	public boolean getActive() {
		return status;
	}
}
