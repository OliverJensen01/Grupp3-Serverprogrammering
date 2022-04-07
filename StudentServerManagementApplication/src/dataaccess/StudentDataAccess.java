package dataaccess;

import java.util.List;

import javax.ejb.Local;

import domain.Student;

@Local
public interface StudentDataAccess {

	public void insertStudent(Student student);
	public List<Student> getAll();
	public List<Student> findByFirstName(String firstName);
	public Student FindById(int id) throws StudentNotFoundException; 
	public List<Student> FindByClass(String schoolClass);
	void deleteStudent(int id) throws StudentNotFoundException;
	void updateStudent(int id, String schoolClass) throws StudentNotFoundException;
}
