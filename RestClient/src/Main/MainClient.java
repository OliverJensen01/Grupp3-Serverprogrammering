package Main;

import java.util.Scanner;
import Functions.StudentClientFunctions;

public class MainClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean looping = true;
		
		while (looping) {
			
			System.out.println("What do you want to do?");

			System.out.println("1. Create Student");
			System.out.println("2. Find All Students");
			System.out.println("3. Find Specific Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Update Student");
			System.out.println("6. Quit");
			
			String string = scan.nextLine();

			switch (string) {
			case "1":
				StudentClientFunctions.CreateStudent();
				break;
			case "2":
				StudentClientFunctions.ShowAllStudents();
				break;
			case "3":
				StudentClientFunctions.FindStudent();
				break;
			case "4":
				StudentClientFunctions.DeleteStudent();
				break;
			case "5":
				StudentClientFunctions.UpdateStudent();
				break;
			case "6": looping = false;
				break;
			}

		}
	}

}
