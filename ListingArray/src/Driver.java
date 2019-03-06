import java.util.Scanner;
import java.util.ArrayList;
public class Driver {
	
	static Scanner a = new Scanner(System.in);
	
	public static void main(String[] args) {
		Listing[] ListArray = new Listing[3];
//		String name = " ";
//		int age = 0;

		for (int i = 0; i < ListArray.length; i++) {
			
			System.out.println("Person " + (i+1) + " info:");
			System.out.println("What is your name?");
//			name = a.nextLine();	
			String name = a.nextLine();	
			System.out.println("How old are you?");
//			age = a.nextInt();
			int age = Integer.parseInt(a.nextLine());
			ListArray[i] = new Listing(name, age);
		}
		a.close();

		for (int i = ListArray.length - 1; i >= 0; i--) {
			System.out.println("Person " + (i + 1));
			System.out.println("\tName: " + ListArray[i].getName());
			System.out.println("\tAge: " + ListArray[i].getAge());
		}

	}

}
