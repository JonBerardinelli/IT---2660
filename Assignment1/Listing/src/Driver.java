import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		System.out.println("What is your name?");
		Scanner a = new Scanner(System.in);		
		String name = a.nextLine();
//		a.close();
		System.out.println("How old are you?");
//		Scanner b = new Scanner(System.in);		
		int age = a.nextInt();
		a.close();

		Listing person = new Listing(name, age);
//		person.getAge();
		System.out.println("Your name is " + person.getName());
		System.out.println("Your age is " + person.getAge());

	}

}
