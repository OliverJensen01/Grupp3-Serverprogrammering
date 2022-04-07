package dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Student;

@Stateless
@Default
public class StudentDataAccessProductionVersion implements StudentDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertStudent(Student student) {
		em.persist(student);
	}

	@Override
	public List<Student> getAll() {
		Query q = em.createQuery("SELECT student FROM Student student");
		List<Student> students = q.getResultList();
		return students;
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		Query q = em.createQuery("SELECT student FROM Student student WHERE student.firstName = :firstName");
		q.setParameter("firstName", firstName);
		return q.getResultList();
	}

	@Override
	public Student FindById(int id) throws StudentNotFoundException {
		Query q = em.createQuery("SELECT student FROM Student student WHERE student.id = :id");
		q.setParameter("id", id);

		try {
			return (Student) q.getSingleResult();
		} catch (NoResultException e) {
			throw new StudentNotFoundException();
		}
	}

	@Override
	public List<Student> FindByClass(String schoolClass) {
		Query q = em.createQuery("SELECT student FROM Student student WHERE student.schoolClass = :schoolClass");
		q.setParameter("schoolClass", schoolClass);
		return q.getResultList();
	}
	
	@Override
	public void updateStudent(int id, String schoolClass) throws StudentNotFoundException
	{
		Student e = FindById(id);
		e.setSchoolClass(schoolClass);
	}
	
	@Override
	public void deleteStudent(int id) throws StudentNotFoundException {
		Student e = FindById(id);
		em.remove(e);
	}

}
