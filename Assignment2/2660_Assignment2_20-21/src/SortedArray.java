
public class SortedArray {
	private int next;
	private int size;
	private CollegeStudentListing[] data;
	
	public SortedArray() {
		next = 0;
		size = 100;
		data = new CollegeStudentListing[size];
	}
	public CollegeStudentListing fetch(String targetKey) {
		int low = 0;
		int high = next - 1;
		int i =  (low + high) / 2;

		while (targetKey != data[i].key) 
		{   if(targetKey < data[i].key && high != low))
		    {  high = i - 1;} 
		    else
		    {  low = i + 1; } 
		        i = (low + high) / 2;
		    }
		}

		return data[i].deepCopy();

	}

}
