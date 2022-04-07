package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dataaccess.StudentNotFoundException;
import domain.Student;
import service.StudentManagementService;

@Stateless
@Path("/students")
public class StudentResource {

	@Inject
	private StudentManagementService service;

	@GET
	@Produces("application/JSON")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GET
	@Produces("application/JSON")
	@Path("{studentNo}")
	public Response findStudentByID(@PathParam("studentNo") int id) {
		try {
			Student result = service.getById(id);
			return Response.ok(result).build();
		} catch (StudentNotFoundException e) {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("{studentNo}")
	public Response deleteStudent(@PathParam("studentNo") int id) {
		try {
			service.DeleteStudent(id);
			return Response.status(204).build();
		} catch (StudentNotFoundException e) {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("{studentNo}")
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response updateStudent(@PathParam("studentNo") int id, Student e) {
		try {
			service.UpdateStudent(id, e.getSchoolClass());
			return Response.ok(service.getById(id)).build();
		} catch (StudentNotFoundException e1) {
			return Response.status(404).build();
		}
	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Student createStudent(Student student) {
		service.registerStudent(student);
		return student;
	}
}
