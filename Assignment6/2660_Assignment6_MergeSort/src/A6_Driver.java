
public class A6_Driver {

	public static void main(String[] args) {
		int[] randomNumbers = new int[100];
		int[] work = new int[100];
        MergeSort merge = new MergeSort();
        
        System.out.println("Unsorted Array:");        
        merge.PrintUnsortedArray(randomNumbers);

        System.out.println("Sorted Array");        
        merge.TopDownMergeSort(randomNumbers, work, 100);
        merge.PrintSortedArray(randomNumbers);

	}

}
