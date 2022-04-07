package service;

import java.util.List;

import javax.ejb.Local;

import dataaccess.StudentNotFoundException;
import domain.Student;

@Local
public interface StudentManagementService {
	public void registerStudent(Student student);
	public List<Student> getAllStudents();
	public List<Student> searchByFirstName(String firstName);
	public Student getById(int id) throws StudentNotFoundException; 
	public List<Student> getByClass(String schoolClass);
	void DeleteStudent(int id) throws StudentNotFoundException;
	void UpdateStudent(int id, String schoolClass) throws StudentNotFoundException;
} 
