package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int id;				
	@Column(name="name")
	private String name;
	@Column(name="lastname")
	private String lastname;
	@Column(name="age")
	private int age;
	
	public Student() {
		
	}

	public Student(int id, String name, String lastname, int age) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
