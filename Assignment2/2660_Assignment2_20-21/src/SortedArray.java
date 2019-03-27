import javax.swing.JOptionPane;

public class SortedArray {
	private int next;
	private int size;
	private CollegeStudentListing[] data;
	
	public SortedArray() {
		next = 0;
		size = 100;
		data = new CollegeStudentListing[size];
	}
	public SortedArray(int s) {
		next = 0;
		data = new CollegeStudentListing[s];
		size = s;		
	}
	public boolean insert(CollegeStudentListing newListing) {
		if(next >= size) {
			return false;
		}
		data[next] = newListing.deepCopy();
		
		if(data[next] ==  null) {
			return false;			
		}
		next = next + 1;
		return true;
	}
	public CollegeStudentListing fetch(String targetKey) {
		CollegeStudentListing listing;
		CollegeStudentListing temp;
		
		int i = 0;
		while(i < next && !(data[i].compareTo(targetKey) == 0)) {
			i++;
		}
		if(i == next) {
			return  null;
		}
		listing = data[i].deepCopy();
		
		if (i !=0) {
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return listing;		
	}
	public boolean delete(String targetKey) {
		int i = 0;
		while(i < next && !(data[i].compareTo(targetKey) == 0)) {
			i++;
		}
		if(i == next) {
			return  false;
		}
		
		data[i] = data[next - 1];
		data[next - 1] = null;
		next = next - 1;
		return true;
	}
	
	public boolean update(String targetKey, CollegeStudentListing newListing) {
		if(delete(targetKey) == false) {
			return false;			
		}
		else if (insert(newListing) == true) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String showAll() {
		String printAll = "";		
		for(int i = 0; i< next; i++) {
			printAll += data[i].toString() + "\n";	
		}
		return printAll;
	}
	
	public void InitialStudentEntry(CollegeStudentListing Student, SortedArray Array) {
		String arrayNum = JOptionPane.showInputDialog("Enter how many students you will "
				+ "enter in first:");
		int arrayIntNum = 0;
		try{
		    if(arrayNum != null) {
		    	arrayIntNum = Integer.parseInt(arrayNum);
		    }
		}
		catch (NumberFormatException e){
			arrayIntNum = 0;
		}
		for (int i = 0; i < arrayIntNum; i++) {
			Student.input();
			Array.insert(Student);
		}
	}
	
	public void UserFuntionSelection(CollegeStudentListing Student, SortedArray Array) {
		int paneNum = 0;		
		while (paneNum != 6) {
			paneNum = Student.SelectPane();
			switch (paneNum) {
			case 1:
				Student.input();
				Array.insert(Student);
				break;
			case 2:
				String searchName = JOptionPane.showInputDialog("Enter a name to search for");
				if (Array.fetch(searchName) == null) {
					JOptionPane.showMessageDialog(null, "There is no record of that student.");
				}
				else {
					JOptionPane.showMessageDialog(null, Array.fetch(searchName));
				}
				break;
			case 3:
				String deleteName = JOptionPane.showInputDialog("Enter a name to delete a listing");
				if (Array.delete(deleteName) == false) {
					JOptionPane.showMessageDialog(null, "Student doesn't exist");
				}
				else {
					Array.delete(deleteName);
					JOptionPane.showMessageDialog(null, "Student entry deleted.");
				}
				break;
			case 4:
				String updateName = JOptionPane.showInputDialog("Enter a name to update a listing");
				CollegeStudentListing checkStudent = Array.fetch(updateName);
				if (checkStudent == null) {
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry doesn't exist.");					
				}
				else {
					CollegeStudentListing updateStudent = new CollegeStudentListing();
					updateStudent.input();
					Array.update(updateName, updateStudent);
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry has been changed.");
				}
				break;
			case 5:
				if (Array.showAll() == "") {
					JOptionPane.showMessageDialog(null, "There are no student entries");					
				}
				else {
					JOptionPane.showMessageDialog(null, Array.showAll());
				}
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
