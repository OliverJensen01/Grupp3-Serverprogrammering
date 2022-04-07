package Functions;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import Main.Student;

public class StudentClientFunctions {

	public static void FindStudent() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Which student ID?");
		int studentID = scan.nextInt();

		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students/" + studentID)
				.request("application/JSON").buildGet().invoke();
		System.out.println(response.getHeaders().toString());
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		response.close();
	}

	public static void ShowAllStudents() {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students").request()
				.buildGet().invoke();
		List<Student> Students = response.readEntity(new GenericType<List<Student>>() {
		});

		for (Student e : Students) {
			System.out.println(e);
		}
		response.close();
	}

	public static void CreateStudent() {
		Scanner scan = new Scanner(System.in);
		Student student = new Student();

		System.out.println("What is the name of the student?");
		student.setFirstName(scan.nextLine());
		System.out.println("What is the last name of the student?");
		student.setLastName(scan.nextLine());
		System.out.println("What class does this student belong to?");
		student.setSchoolClass(scan.nextLine());
		System.out.println("How old is the student?");
		student.setAge(scan.nextInt());
		scan.next();

		System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getSchoolClass() + " "
				+ student.getAge());

		Entity studentEntity = Entity.entity(student, "application/JSON");
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students").request()
				.buildPost(studentEntity).invoke();
		response.close();
	}

	public static void DeleteStudent() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Who do you want to Remove?");
		int studentID = scan.nextInt();
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students/" + studentID).request()
				.buildDelete().invoke();
		System.out.println("Delete status was " + response.getStatus());
		response.close();
	}
	
	public static void UpdateStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Who do you want to Update?");
		int studentID = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the new Class of the Student?");
		String newClass = scan.nextLine();
		
		Student updatedStudent = new Student();
		updatedStudent.setSchoolClass(newClass);
		Entity eEntity = Entity.entity(updatedStudent,"application/JSON");
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students/" + studentID)
				.request().buildPut(eEntity).invoke();

		System.out.println("Update status was " + response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();
	}
	

}
