package nl.ycn.coaching.model;

import nl.ycn.coaching.model.users.Trainee;

import javax.persistence.*;
import java.util.HashSet;
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

	//default constructor
	public Bootcamp(){}

	//overloaded constructor
	public Bootcamp (String bootcampName, String courseList) {
		this.bootcampName = bootcampName;
		this.courseList = courseList;
	}
	
	public void getBootcamp() {}

	public String getName() {
		return bootcampName;
	}

	public String getCourseList() {
		return courseList;
	}
}
