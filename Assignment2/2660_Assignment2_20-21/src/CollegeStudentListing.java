import javax.swing.JOptionPane;

public class CollegeStudentListing {
	private String name;
	private String ID;
	private String GPA;
	private String paneSelect;
	
	CollegeStudentListing(){
		
	}
	
	public CollegeStudentListing(String n, String i, String g) {
		name = n;
		ID = i;
		GPA = g;
	}
	
	public String toString() {
		return ("Student Name: " + name + 
				"\nStudent ID: " + ID + 
				"\nStudent GPA: " + GPA + "\n" );
	}
	
	public CollegeStudentListing deepCopy() {
		CollegeStudentListing clone = new CollegeStudentListing(name, ID, GPA);
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
	public int SelectPane() {
		paneSelect = JOptionPane.showInputDialog("Choose a number to decide the next operation:" + 
									"\n\t1: Insert a new student's info" + 
									"\n\t2: Fetch and output a student's info" + 
									"\n\t3: Delete a student's info" + 
									"\n\t4: Update a student's info" + 
									"\n\t5: Output all students' info" + 
									"\n\t6: Exit Program");
		int selectNum = 0;
		try{
		    if(paneSelect != null)
		    	selectNum = Integer.parseInt(paneSelect);
		}
		catch (NumberFormatException e){
			selectNum = 0;
		}		
		return selectNum;
	}

}
