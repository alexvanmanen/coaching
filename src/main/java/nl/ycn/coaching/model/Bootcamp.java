package nl.ycn.coaching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Bootcamp {



	@Id
	@GeneratedValue
	public int id;
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
