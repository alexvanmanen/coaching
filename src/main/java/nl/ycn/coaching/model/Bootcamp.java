package nl.ycn.coaching.model;

import nl.ycn.coaching.model.users.Trainee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
	public String courseList;
	
	public Bootcamp (String bootcampName, String courseList) {
		this.bootcampName = bootcampName;
		this.courseList = courseList;
	}
	
	public Bootcamp () {
	}
	
	public void getBootcamp() {}
}
