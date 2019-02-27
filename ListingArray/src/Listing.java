public class Listing {

	String name = " ";
	int age = 0;
	
	public Listing (String a, int b) {
		name = a;
		age = b;
	}
	
	public String toString() {
		String ageInt = String.valueOf(age);
		return ageInt;
	}

	public void setName(String n) {
		n = getName();
	}
	
	public void setAge(int a) {
		a = getAge();
	}

	public String getName() {
//		toString();
		return name;
	}
	public int getAge() {
		toString();		
		return age;
	}

	
}
