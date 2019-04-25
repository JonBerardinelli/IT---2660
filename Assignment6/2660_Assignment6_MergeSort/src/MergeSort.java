
public class MergeSort {
	public int[] TopDownMergeSort(int mainArray[], int copyArray[], int n) {
	    CopyArray(mainArray, 0, n, copyArray);           
	    SplitMerge(copyArray, 0, n, mainArray);  
	    return mainArray;
	}

	public void SplitMerge(int copyArray[], int start, int end, int mainArray[]) {
	    if(end - start < 2) {                    
	        return;
	    }
	    int middle = (end + start) / 2;             
	    SplitMerge(mainArray, start,  middle, copyArray);  
	    SplitMerge(mainArray, middle,    end, copyArray);  
	    Merge(copyArray, start, middle, end, mainArray);
	}

	public void Merge(int mainArray[], int start, int middle, int end, int copyArray[]) {
	    int a = start;
	    int b = middle;
	 
	    for (int i = start; i < end; i++) {
	        if (a < middle && (b >= end || mainArray[a] <= mainArray[b])) {
	        	copyArray[i] = mainArray[a];
	            a = a + 1;
	        } 
	        else {
	        	copyArray[i] = mainArray[b];
	            b = b + 1;
	        }
	    }
	}

	public void CopyArray(int mainArray[], int start, int end, int copyArray[]) {
	    for(int i = start; i < end; i++)
	    	copyArray[i] = mainArray[i];
	}	
	
	public void PrintUnsortedArray(int unsortedArray[]) {
        for(int i = 0; i < unsortedArray.length; i++)
        {
            int num = (int)Math.floor(Math.random() * 100)+1;
            unsortedArray[i] = num;
            System.out.println("\t" +  i + ": " + unsortedArray[i]);
        }		
	}

	public void PrintSortedArray(int unsortedArray[]) {
        for(int i = 0; i < unsortedArray.length; i++)
        {
            System.out.println("\t" +  i + ": " + unsortedArray[i]);
        }		
	}

}
