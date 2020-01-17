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
	private Set<Trainee> trainees = new HashSet<> ();
	
	@Column
	public String bootcampName;

	@Column
	public String beginDate;

	@Column
	public String endDate;

	@Column
	public String courseList;

	@Column
	public boolean active;

	private String agendaUrl;

	//default constructor
	public Bootcamp(){}

	//overloaded constructor
	public Bootcamp (String bootcampName, String courseList) {
		this.bootcampName = bootcampName;
		this.courseList = courseList;
		this.active = true;
	}
	
	public void getBootcamp() {}

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

	public void setCourseList(String courseList) {
		this.courseList = courseList;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCourseList() {
		return courseList;
	}

	public Set<Trainee> getTrainees(){
		return trainees;
	}

	public String getAgendaUrl() {
		return agendaUrl;
	}
}
