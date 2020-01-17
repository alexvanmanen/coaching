package nl.ycn.coaching.model;

import nl.ycn.coaching.model.users.Trainee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bootcamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Bootcamp(String bootcampName) {
		this.bootcampName = bootcampName;
		this.status = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void getBootcamp() {
	}

	public String getBootcampName() {
		return bootcampName;
	}

	public void setBootcampName(String bootcampName) {
		this.bootcampName = bootcampName;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public boolean isActive() {
		return status;
	}

	public void setActive(boolean active) {
		this.status = active;
	}

	public String getCourseList() {
		return courseList;
	}

	public void setCourseList(String courseListString) {
		this.courseList = courseListString;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public boolean getActive() {
		return status;
	}
}
