package email_Application;

import java.util.Random;
import java.util.Scanner;

public class CredentialService {

	public static void generateEmailAddress(Employee emp)
	{
		emp.setEmail(emp.getFirstName() + emp.getLastName() + "@" + emp.getDepartment() + ".abc.com");
	}
	
	public static void generatePassword(Employee emp)
	{
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String number = "1234567890";
		String specialchar = "!@#$%^&*()=+_-/";
		String allchar = letters + letters.toUpperCase() + number + specialchar;
		char password[] = new char [8];
		Random random = new Random();
		password[0] = letters.charAt(random.nextInt(letters.length()));
		password[1] = letters.toUpperCase().charAt(random.nextInt(letters.toUpperCase().length()));
		password[2] = number.charAt(random.nextInt(number.length()));
		password[3] = specialchar.charAt(random.nextInt(specialchar.length()));
		
		for(int i=4; i<password.length; i++)
		{
			password[i] = allchar.charAt(random.nextInt(allchar.length()));
		}
		
		emp.setPassword(String.valueOf(password));
		
	}
	
	public static void showDetails(Employee emp)
	{
		System.out.println("Dear "+ emp.getFirstName() + " your generated credentials are as follows: ");
		System.out.println("Email ----> " + emp.getEmail() + "\nPassword ----> " +emp.getPassword());
	}
	
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		String fName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String lName = sc.nextLine();
		int choice;
		String department = "";
		System.out.println("Select the Department: ");
		System.out.println("1.Technical \n2.Admin \n3.Human Resource \n4.Legal");
		choice = sc.nextInt();
		switch(choice)
		{
		case 1: department = "tech";
			break;
		case 2: department = "admin";
			break;
		case 3: department = "hr";
			break;
		case 4: department = "legal";
			break;
		default: System.out.println("Not available");
			break;
		}
		
		Employee emp = new Employee(fName, lName);
		emp.setDepartment(department);
		generateEmailAddress(emp);
		generatePassword(emp);
		showDetails(emp);
		sc.close();
	}

}
