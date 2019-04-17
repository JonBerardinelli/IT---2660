public class Stack {
    private Serving[] data;
    private int top;
    private int size;
    
    public Stack() {
        top = -1;
        size = 100;
        data = new Serving[100];
    }
    
    public Stack(int n) {
        top = -1;
        size = n;
        data = new Serving[n];
    }
    public boolean modPush(Serving newNode)
    {
    	Serving[] sizeTemp;
    	Serving[] sizeIncrease;
    	int lengthPlus = data.length + 1;
    	
    	sizeIncrease = new Serving[lengthPlus];
        
        if(top >= size - 1) {
        	sizeTemp = data;
            data = sizeIncrease;            
            for(int i = 0; i < sizeTemp.length; i++) {                    
                data[i] = sizeTemp[i];
            }
            top = top + 1;
            data[top] = newNode.deepCopy();            
        }
        else {
            top = top + 1;
            data[top] = newNode.deepCopy();
        }
            return true;       
    }
    
    public Serving pop() {
        int stackTop;
    	System.out.println("Popping Stack");
        if(top == -1) {
        	System.out.println("\tNothing in stack to pop\n");
            return null;
        }//Underflow error
        else {
        	stackTop = top;
            top = top - 1;
            return data[stackTop];
        }
    }
    
    public void peek() {
        int topPeek;
    	System.out.println("Taking a peek at the top of the Stack:");
        if(top == -1) {
        	System.out.println("\tNothing in stack to peek\n");
        }
        else {
            topPeek = top;
            System.out.println(data[topPeek]+"\n");
        }
    }
    
    public void showAll() {
    	System.out.println("Displaying stack contents:");    	
    	if (top == -1) {
    		System.out.println("\tNothing in the stack to display\n");
    	}
    	else {	
	    	for(int i = top; i >= 0; i--) {        	
	        	System.out.println(data[i].toString());        	
	    	}	    	
    	}
    }
}