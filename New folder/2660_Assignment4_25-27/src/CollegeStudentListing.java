import javax.swing.JOptionPane;

public class CollegeStudentListing extends Node{
    private String name;
    private String Id;
    private String Gpa;
	private String paneSelect;
    
    public CollegeStudentListing(){
        this.name = "";
        this.Id = "";
        this.Gpa = "";
    }
    
    public CollegeStudentListing(String n, String num, String gpa)
    {
        this.name = n;
        this.Id = num;
        this.Gpa = gpa;
    }
    
    public String toString()
    {
        return("The Name is: " + name +
                "\nTheir identification number is: " + Id + 
                "\nTheir GPA is " + Gpa);
    }
    
    public CollegeStudentListing deepCopy()
    {
        CollegeStudentListing clone = new CollegeStudentListing(name, Id, Gpa);
        return clone;
    }
    
    public int compareTo(String targetKey)
    {
        return(this.name.compareTo(targetKey));
    }
    
    public void setGpa(String gpa)
    {
        this.Gpa = gpa;
    }
    
    public void input()
    {
        this.name = JOptionPane.showInputDialog("Enter the students name.");
        this.Id = JOptionPane.showInputDialog("Enter the students identification number.");
        this.Gpa = JOptionPane.showInputDialog("Enter the students GPA");
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
		    if(paneSelect != null) {
		    	selectNum = Integer.parseInt(paneSelect);
		    }
		}
		catch (NumberFormatException e){
			selectNum = 0;
		}		
		return selectNum;
	}
	public Integer toInt() {
		return Integer.parseInt(Id);
	}

	public void InitialStudentEntry(CollegeStudentListing Student, SinglyLinkedList Node) {
		String enterNum = JOptionPane.showInputDialog("Enter how many students you will "
				+ "enter in first:");
		int enterIntNum = 0;
		try{
		    if(enterNum != null) {
		    	enterIntNum = Integer.parseInt(enterNum);
		    }
		}
		catch (NumberFormatException e){
			enterIntNum = 0;
		}
		for (int i = 0; i < enterIntNum; i++) {
			Student.input();
			Node.insertNodeAtPosition(Node, i);
		}
	}

	public void UserFuntionSelection(CollegeStudentListing Student, SinglyLinkedList Node) {
		int paneNum = 0;		
		while (paneNum != 6) {
			paneNum = Student.SelectPane();
			int position = Student.toInt();
			switch (paneNum) {
			case 1:
				Student.input();
				Node.insert(Student, position);
				break;
			case 2:
				String searchName = JOptionPane.showInputDialog("Enter a name to search for");
				if (Node.fetch(searchName) == null) {
					JOptionPane.showMessageDialog(null, "There is no record of that student.");
				}
				else {
					JOptionPane.showMessageDialog(null, Node.fetch(searchName));
				}
				break;
			case 3:
				String deleteName = JOptionPane.showInputDialog("Enter a name to delete a listing");
				if (Node.delete(deleteName) == false) {
					JOptionPane.showMessageDialog(null, "Student doesn't exist");
				}
				else {
					Node.delete(deleteName);
					JOptionPane.showMessageDialog(null, "Student entry deleted.");
				}
				break;
			case 4:
				String updateName = JOptionPane.showInputDialog("Enter a name to update a listing");
				Node checkStudent = Node.fetch(updateName);
				if (checkStudent == null) {
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry doesn't exist.");					
				}
				else {
					CollegeStudentListing updateStudent = new CollegeStudentListing();
					updateStudent.input();
					Node.update(updateName, updateStudent, position);
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry has been changed.");
				}
				break;
			case 5:
				Node.showAll();				
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Thank you, have a nice day.");	
				break;
			default:
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
				break;
			}
		}		
	}


}
