
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


}
