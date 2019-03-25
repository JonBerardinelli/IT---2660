import javax.swing.JOptionPane;

public class Driver3_2 {

	public static void main(String[] args) {
		CollegeStudentListing student = new CollegeStudentListing();
		SortedArray array = new SortedArray();
		String arrayNum = JOptionPane.showInputDialog("Enter how many students you will "
				+ "enter in first:");
		int arrayIntNum = Integer.parseInt(arrayNum);
		for (int i = 0; i < arrayIntNum; i++) {
			student.input();
			array.insert(student);
		}
		int paneNum = 0;
		
		while (paneNum != 6) {
			paneNum = student.SelectPane();
			switch (paneNum) {
			case 1:
				student.input();
				array.insert(student);
				break;
			case 2:
				String searchName = JOptionPane.showInputDialog("Enter a name to search for");
				if (array.fetch(searchName) == null) {
					JOptionPane.showMessageDialog(null, "There is no record of that student.");
				}
				else {
					JOptionPane.showMessageDialog(null, array.fetch(searchName));
				}
				break;
			case 3:
				String deleteName = JOptionPane.showInputDialog("Enter a name to delete a listing");
				array.delete(deleteName);
				JOptionPane.showMessageDialog(null, "Student entry deleted.");
				break;
			case 4:
				String updateName = JOptionPane.showInputDialog("Enter a name to update a listing");
				CollegeStudentListing updateStudent = new CollegeStudentListing();
				updateStudent.input();
				array.update(updateName, updateStudent);
				JOptionPane.showMessageDialog(null, array.fetch(updateName));
				break;
			case 5:
				JOptionPane.showMessageDialog(null, array.showAll());
				break;
			}
		}		
	}
}
