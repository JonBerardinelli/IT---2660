import javax.swing.JOptionPane;

public class Driver3 {
	public static void main(String[] args) {
		StudentListings student = new StudentListings();
		student.input();
		JOptionPane.showMessageDialog(null, student.toString());
		JOptionPane.showMessageDialog(null, "Copy Result \n" + student.deepCopy());
		JOptionPane.showMessageDialog(null, "Comparing lexicographically yeilds : " 
		+ student.compareTo(JOptionPane.showInputDialog("Enter a name to compare")));
	}
}
