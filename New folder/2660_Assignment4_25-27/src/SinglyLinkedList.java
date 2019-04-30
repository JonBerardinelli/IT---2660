
public class SinglyLinkedList extends Node {
	
    private Node h;     
    private Node l;     
    private Node next;
    private int size;
    
    public SinglyLinkedList()
    {
        h = new Node();
        l = null;
        next = null;
        size = 0;
    }
    public Node insertNodeAtPosition(Node newNode, int position) {
    	if (position == 0) {
    		return newRoot(newNode);
    	}
    	if (position == size) {
    		return append(newNode);
    	}        	
    	Node prevNode = getNodeAtPosition(position - 1);
    	newNode.setNextNode(prevNode.getNextNode());
    	prevNode.setNextNode(newNode);
    	return this;
    }
    public Node getNodeAtPosition(int position) {
    	Node search = this;
    	for (int i = 0; i < position; i++) {
    		search = search.getNextNode();
    	}
    	return search;
    }
    public Node append(Node node) {
    	Node lastNode = getNodeAtPosition(size - 1);
    	lastNode.setNextNode(node);
    	return this;
    }
    public Node newRoot(Node newRoot) {
    	newRoot.setNextNode(this);
    	return newRoot;
    }
    public void insertNewRoot(Node node)
    {
        node.setNextNode(h);
        h = node;
        size++;
    }
    
    
    public boolean insert(Node newNode, int index)
    {
        if(newNode == null)
        return false;
        else
        {
        	Node target = getNode(index, false);
	        newNode.setNextNode(target.getNextNode());
	        target.setNextNode(newNode);
	        size++;
	        return true;
        }
    }
    
    public void printList()
    {
        System.out.println("List size: " + size);
        getNode(size, true);
    }
    
    public Node getNode(int pos, boolean print)
    {
    	Node w = h;
        
        for(int i = 1; i <= pos; i++)
        {
            if(print)
            {
                System.out.println(w.getValue() + " ");
            }
            
            w = w.getNextNode();
        }
        
        return w;
    }
    
    public Node fetch(String targetKey)
    {
    	Node p = h.getNextNode();
        while(p != null && !(p.getValue().compareTo(targetKey) == 0))
        {
            p = p.getNextNode();
        }
        if(p != null)
            return p.deepCopy();
        else 
            return null;
    }
    
    public boolean delete(String targetKey)
    {
    	Node q = h;
    	Node p = h.getNextNode();
        while(p != null && !(p.getValue().compareTo(targetKey) == 0))
        {
            q = p;
            p = p.getNextNode();
        }
        if(p != null)
        {
            q.setNextNode(p.getNextNode());
            return true;
        }
        else
            return false;
    }
    
    public boolean update(String targetKey, Node newNode, int pos)
    {
        if(delete(targetKey) == false)
            return false;
        else if(insert(newNode,pos) == false)
            return false;
        return true;
    }
    
    public void showAll()
    {
    	Node p = h.getNextNode();
        while(p != null)
        {
            System.out.println(p.getValue());
            System.out.println(p.getStudentList());
            p = p.getNextNode();
        }
    }

    

}
