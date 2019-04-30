
public class Node {
    private String value;
    private Node next;
    private CollegeStudentListing list;
   
   public Node()
   {
       
   }
   public Node(String newValue, CollegeStudentListing newList)
   {
       this.value = newValue;
       this.list = newList;
   }
   
   public String getValue()
   {
       return this.value;
   }
   
   public Node getNextNode()
   {
       return this.next;
   }
   
   public void setNextNode(Node nextNode)
   {
       this.next = nextNode;
   }
   
   public Node deepCopy()
   {
	   Node clone = new Node(value, list);
       return clone;
   }
   
   public CollegeStudentListing getStudentList()
   {
       return this.list;
   }
   
   public void print()
   {
       System.out.println(list);
   }

    }
