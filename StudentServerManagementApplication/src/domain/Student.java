package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private int age;
	private String schoolClass;

	public Student(int id, String firstName, String lastName, int age, String schoolClass) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.schoolClass = schoolClass;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	@Override
	public String toString() {
		return "Student id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", schoolClass=" + schoolClass;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

}
