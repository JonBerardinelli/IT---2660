import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class SimpleGraph {
	Listing vertex[];
	int edge[][];
	int max;
	int numberOfVertices;
	int count = 0;
    private boolean visited[];
    private String paneSelect;
	
	public SimpleGraph(int n) {
		vertex = new Listing[n];
		edge = new int[n][n];
		max = n;
		numberOfVertices = 0;		
	}
	
	public void DFT(int firstVertex) {
		int v;
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i<numberOfVertices; i++) {
			if (vertex[i] != null) {
				vertex[i].setPushed(false);
			}
		}
		stack.push(firstVertex);
		vertex[firstVertex].setPushed(true);
		
		while (!stack.empty()) {
			v = stack.pop();
			vertex[v].visit();
			for (int column = 0; column < numberOfVertices; column++) {
				
				if(edge[v][column] == 1 && !vertex[column].getPushed()) {
					stack.push(column);
					vertex[column].setPushed(true);
				}
			}
		}
	}
    public void BFT(int firstVertex)
    {
        int v;
        Queue<Integer> queue = new LinkedList();
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            vertex[i].setPushed(false);
        }
        queue.add(firstVertex);
        vertex[firstVertex].setPushed(true);
        
        while(!queue.isEmpty())
        {
            v = queue.remove();
            vertex[v].visit();
            count++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[v][column] == 1 && !vertex[column].getPushed())
                {
                    queue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }

	/*
    public void BFT(int v)
    {
    	numerOfVertices = v;
        visited = new boolean[numerOfVertices];
        adjLists = new Listing[numerOfVertices];
        for (int i=0; i = adjLists[currVertex].listIterator();
            while (i.hasNext())
            {
                int adjVertex = i.next();
                if (!visited[adjVertex])
                {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
    }
    */
    public void Dijkstra(Listing a) {
    	//Listing[0] = a;
    	int numVerticesIncluded = 1;
    	for(int i = 0; i < numberOfVertices; i++) {
    		
    	}
    	
    }
	
	public boolean insertVertex(int vertexNumber, Listing newListing) {
		if(vertexNumber >= max) {
			return false;
		}
		vertex[vertexNumber] = newListing.deepCopy();
		numberOfVertices++;
		return true;		
	}
	public boolean insertEdge(int fromVertex, int toVertex) {
		if(vertex[fromVertex] == null || vertex[toVertex] == null)
			return false;
		edge[fromVertex][toVertex] = 1;
		return true;		
	}
	public void showVertex(int vertexNumber) {
		System.out.println(vertex[vertexNumber]);
	}
	public void showEdges(int vertexNumber) {
		for(int column = 0; column < numberOfVertices; column++) {
			if(edge[vertexNumber][column] == 1) {
				System.out.println(vertexNumber + "," + column);				
			}
		}
	}
	public int SelectPane() {
		paneSelect = JOptionPane.showInputDialog("Choose a number to decide the next operation:" + 
									"\n\t1: Use Depth-First Method" + 
									"\n\t2: Use Breadth-First Method" + 
									"\n\t3: Use Dijkstra's Method" + 
									"\n\t4: Close  Program");
		int selectNum = 0;
		try{
		    if(paneSelect != null) {
		    	selectNum = Integer.parseInt(paneSelect);
		    }
		}
		catch (NumberFormatException e){
			selectNum = 0;
		}		
		return selectNum;
	}
	public void FormulaChoice(SimpleGraph fly, int vertexStart) {
		int paneNum = 0;
		while (paneNum != 4) {
			paneNum = SelectPane();
			switch (paneNum) {
			case 1:
				fly.DFT(vertexStart);
				break;
			case 2:
				fly.BFT(vertexStart);
				break;
			case 3:
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Thank you, have a nice day.");	
				break;
			default:
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
				break;
			}
		}
	}


}
