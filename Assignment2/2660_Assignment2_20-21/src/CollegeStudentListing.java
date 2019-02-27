import javax.swing.JOptionPane;

public class CollegeStudentListing {
	public class StudentListings {
		private String name;
		private String ID;
		private String GPA;
		
		StudentListings(){
			
		}
		
		public StudentListings(String n, String i, String g) {
			name = n;
			ID = i;
			GPA = g;
		}
		
		public String toString() {
			return ("Student Name: " + name + 
					"\nStudent ID: " + ID + 
					"\nStudent GPA: " + GPA + "\n" );
		}
		
		public StudentListings deepCopy() {
			StudentListings clone = new StudentListings(name, ID, GPA);
			return clone;
		}
		
		public int compareTo(String targetKey) {
			return(name.compareTo(targetKey));
		}
		
		public void input() {
			name = JOptionPane.showInputDialog("Enter a name");
			ID = JOptionPane.showInputDialog("Enter an ID");
			GPA = JOptionPane.showInputDialog("Enter a GPA");
			
		}
	}
}
