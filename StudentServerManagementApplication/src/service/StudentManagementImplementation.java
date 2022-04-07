package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dataaccess.StudentDataAccess;
import dataaccess.StudentNotFoundException;
import domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService {

	@Inject
	private StudentDataAccess dao;
	
	@Override
	public void registerStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.getAll();
	}

	@Override
	public List<Student> searchByFirstName(String firstName) {
		return dao.findByFirstName(firstName);
	}

	@Override
	public Student getById(int id) throws StudentNotFoundException {
		return dao.FindById(id);
	}

	@Override
	public List<Student> getByClass(String schoolClass) {
		return dao.FindByClass(schoolClass);
	}
	
	@Override
	public void UpdateStudent(int id, String schoolClass) throws StudentNotFoundException
	{
		dao.updateStudent(id, schoolClass);
	}
	
	@Override
	public void DeleteStudent(int id) throws StudentNotFoundException {
		dao.deleteStudent(id);
	}

}
