import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Listing[] ListArray = new Listing[3];
		String name = " ";
		int age = 0;

		for (int i = 0; i < ListArray.length; i++) {
			
			Scanner a = new Scanner(System.in);		
			System.out.println("Person " + (i+1) + " info:");
			System.out.println("What is your name?");
			name = a.nextLine();	
//			String name = a.nextLine();	
			System.out.println("How old are you?");
			age = a.nextInt();
//			int age = a.nextInt();
			ListArray[i] = new Listing(name, age);
			a.close();
		}
		for (int i = ListArray.length; i >= 0; i--) {
			System.out.println("Person " + ListArray[i] + ": ");
			System.out.println("Name is " + ListArray[i].getName());
			System.out.println("Age is " + ListArray[i].getAge());
		}

	}

}
