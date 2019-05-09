import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

public class SimpleGraph {
	Listing vertex[];
	int edge[][];
	int max;
	int numberOfVertices;
    private boolean visited[];
    private String paneSelect;
	int nodeCheck = 0;
    int selectNum = 0;

	public SimpleGraph(int n) {
		vertex = new Listing[n];
		edge = new int[n][n];
		max = n;
		numberOfVertices = 0;		
	}
	
	public void DFT(int firstVertex) {
		int v;
		Stack<Integer> nodeStack = new Stack();
		
		for(int i = 0; i<numberOfVertices; i++) {
			if (vertex[i] != null) {
				vertex[i].setPushed(false);
			}
		}
		nodeStack.push(firstVertex);
		vertex[firstVertex].setPushed(true);
		
		while (!nodeStack.empty()) {
			v = nodeStack.pop();
			vertex[v].visit();
			nodeCheck++;
			for (int column = 0; column < numberOfVertices; column++) {
				
				if(edge[v][column] == 1 && !vertex[column].getPushed()) {
					nodeStack.push(column);
					vertex[column].setPushed(true);
				}
			}
		}
	}
    public void BFT(int firstVertex)
    {
        int v;
        Queue<Integer> nodeQueue = new LinkedList();
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            vertex[i].setPushed(false);
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);
        
        while(!nodeQueue.isEmpty())
        {
            v = nodeQueue.remove();
            vertex[v].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[v][column] == 1 && !vertex[column].getPushed())
                {
                	nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }
    
    public void Dijkstra(int firstVertex)
    {
        int v;
        Queue<Integer> nodeQueue = new LinkedList();
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            vertex[i].setPushed(false);
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);
        
        while(!nodeQueue.isEmpty())
        {
            v = nodeQueue.remove();
            vertex[v].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[v][column] == 1 && !vertex[column].getPushed())
                {
                	nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
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
		System.out.print(vertex[vertexNumber]);
	}
	public void showEdges(int vertexNumber) {
		for(int column = 0; column < numberOfVertices; column++) {
			if(edge[vertexNumber][column] == 1) {
				System.out.println(vertexNumber + "," + column);				
			}
		}
		System.out.println();
	}
	
	public void InitializeNodes(SimpleGraph Graph, int nodesNum) {
        Random random = new Random();        
        for (int i = 0; i < nodesNum; i++ ) {
        	Listing v = new Listing(random.nextInt(300000) + 1);
        	Graph.insertVertex(i, v);
        }
                
        int vertexListNumber = Graph.vertex.length;  
        List<Integer> list = new ArrayList<>();       
        for (int i = 0; i < nodesNum; i++ ) {
        	list.add(i);
        }
    	Collections.shuffle(list);
        for (int i = 0; i < vertexListNumber; i++ ) {
        	int randnum = random.nextInt(5); 
        	for (int j = 0; j < randnum; j++ ) {
            	int rando = random.nextInt(5); 
        		Graph.insertEdge(i, list.get(rando));                                   	            	
            }
        }

	}
	public int Search() {
		
		String search = JOptionPane.showInputDialog("Enter Node to search:");
		try{
		    if(search != null) {
		    	selectNum = Integer.parseInt(search);
		    }
		}
		catch (NumberFormatException e){
			selectNum = 0;
		}		
		return selectNum;
	}
	public int SelectPane() {
		paneSelect = JOptionPane.showInputDialog("Choose a number to decide how to search:" + 
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
	public void FormulaChoice(SimpleGraph graph, int vertexStart) {
		int paneNum = 0;
		while (paneNum != 4) {
			paneNum = SelectPane();
			switch (paneNum) {
			case 1:
				graph.DFT(vertexStart);
				System.out.println("Nodes counted were: " + nodeCheck);
				System.out.println("------------------------------------");
				break;
			case 2:
				graph.BFT(vertexStart);
				System.out.println("Nodes counted were: " + nodeCheck);
				System.out.println("------------------------------------");
				break;
			case 3:
				graph.Dijkstra(vertexStart);
				System.out.println("Nodes counted were: " + nodeCheck);
				System.out.println("------------------------------------");
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
