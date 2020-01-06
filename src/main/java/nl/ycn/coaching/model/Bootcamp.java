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
	public Date beginDate;

	@Column
	public Date endDate;
	
	@Column
	public String courseList;


	
	public Bootcamp (String bootcampName, String courseList) {
		this.bootcampName = bootcampName;
		this.courseList = courseList;
	}
	
	public void getBootcamp() {}
}
