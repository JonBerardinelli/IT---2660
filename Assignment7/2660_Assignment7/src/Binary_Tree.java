import javax.swing.JOptionPane;

public class Binary_Tree {
	  
    TreeNode root;
    int size = 0;
    
    public Binary_Tree() {
        root = null;
    }
    
    public boolean insert(CollegeStudentListing newListing)
    {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode n = new TreeNode();
        
        if(n == null) {
            return false;
        }
        else
        {
            n.node = newListing.deepCopy();
            n.lc = null;
            n.rc = null;
            if(root == null)
            {
                root = n;
            }
            else
            {
                findNode(newListing.getKey(),p,c);
                if(newListing.getKey().compareTo(p.get().node.getKey()) < 0) {
                    p.get().lc = n;
                }
                else {
                    p.get().rc = n;
                }
                size++;
            }
            return true;
        }
    }
    
    public CollegeStudentListing fetch(String targetKey)
    {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        found = findNode(targetKey, p, c);
        if(found == true) {
            return c.get().node.deepCopy();
        }
        else {
            return null;
        }
    }
    
    public boolean delete(String targetKey)
    {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode largest = new TreeNode();
        TreeNode nextLargest = new TreeNode();
        found = findNode(targetKey, p, c);
        if(found == false) {
            return false;
        }
        else
        {
            if(c.get().lc == null && c.get().rc == null){
                if(p.get().lc == c.get()) {
                    p.get().lc = null;
                }
                else {
                    p.get().rc = null;
                }
            }
            else if(c.get().lc == null || c.get().rc == null) {
                if(p.get().lc == c.get()) {
                    if(c.get().lc != null) {
                        p.get().lc = c.get().lc;
                    }
                    else {
                        p.get().lc = c.get().rc;
                    }
                }
                else
                {
                    if(c.get().lc != null) {
                        p.get().rc = c.get().lc;
                    }
                    else {
                        p.get().rc = c.get().rc;
                    }
                }
            }
            else {
                nextLargest = c.get().lc;
                largest = nextLargest.rc;
                if(largest != null) {
                    while(largest.rc != null) {
                        nextLargest = largest;
                        largest = largest.rc;
                    }
                    c.get().node = largest.node;
                    nextLargest.rc = largest.lc;
                }
                else {
                    nextLargest.rc = c.get().rc;
                    if(p.get().lc == c.get()) {
                        p.get().lc = nextLargest;
                    }
                    else {
                        p.get().rc = nextLargest;
                    }
                }
            }
            size--;
            return true;
        }
    }
    
    public boolean update(String targetKey, CollegeStudentListing newListing)
    {
        if(delete(targetKey) == false) {
            return false;
        }
        else if(insert(newListing) == false) {
            return false;
        }
        return true;
    }
    
    public String treeCheck(TreeNode root)
    {
        String print = "";
        if(root.lc != null) {
        	treeCheck(root.lc);
        }
		for (int i = 0; i < size; i++) {
	        print += root.node.toString();			
		}
        if(root.rc != null) {
        	treeCheck(root.rc);
        }
       return print;
    }
    
    public String showAll()
    {
        String printAll = "";
       	printAll = treeCheck(root);        
    	return printAll;
    }
    
    public class TreeNode {
        
	    private CollegeStudentListing node;
	    private TreeNode lc;
	    private TreeNode rc;
	    
	    public TreeNode() {
	    }
    }
    
    public boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
        parent.set(root);
        child.set(root);
        if(root == null)
            return true;
        while(child.get() != null) {
            if(child.get().node.compareTo(targetKey) == 0) {
                return true;
            }
            else {
                parent.set(child.get());
                if(targetKey.compareTo(child.get().node.getKey()) < 0) {
                    child.set(child.get().lc);
                }
                else {
                    child.set(child.get().rc);
                }
            }
        }
        return false;
    }
    
    public class TreeNodeWrapper {
        TreeNode treeRef = null;
        
        public TreeNodeWrapper() {  
        }
        
        public TreeNode get() {
            return treeRef;
        }
        
        public void set(TreeNode t) {
            treeRef = t;
        }
    }
	public void InitialStudentEntry(CollegeStudentListing Student, Binary_Tree tree) {
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
			tree.insert(Student);
		}
	}
	
	public void UserFuntionSelection(CollegeStudentListing Student, Binary_Tree tree) {
		int paneNum = 0;		
		while (paneNum != 6) {
			paneNum = Student.SelectPane();
			switch (paneNum) {
			case 1:
				Student.input();
				tree.insert(Student);
				break;
			case 2:
				String searchName = JOptionPane.showInputDialog("Enter a name to search for");
				if (tree.fetch(searchName) == null) {
					JOptionPane.showMessageDialog(null, "There is no record of that student.");
				}
				else {
					JOptionPane.showMessageDialog(null, tree.fetch(searchName));
				}
				break;
			case 3:
				String deleteName = JOptionPane.showInputDialog("Enter a name to delete a listing");
				if (tree.delete(deleteName) == false) {
					JOptionPane.showMessageDialog(null, "Student doesn't exist");
				}
				else {
					tree.delete(deleteName);
					JOptionPane.showMessageDialog(null, "Student entry deleted.");
				}
				break;
			case 4:
				String updateName = JOptionPane.showInputDialog("Enter a name to update a listing");
				CollegeStudentListing checkStudent = tree.fetch(updateName);
				if (checkStudent == null) {
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry doesn't exist.");					
				}
				else {
					CollegeStudentListing updateStudent = new CollegeStudentListing();
					updateStudent.input();
					tree.update(updateName, updateStudent);
					JOptionPane.showMessageDialog(null, "Student " + updateName + "'s entry has been changed.");
				}
				break;
			case 5:
				
				if (tree.showAll() == "") {
					JOptionPane.showMessageDialog(null, "There are no student entries");					
				}
				else {
					JOptionPane.showMessageDialog(null, tree.showAll());
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
