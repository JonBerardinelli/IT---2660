import java.util.Random;

public class MainSimpleGraph {

	public static void main(String[] args) {
        Random random = new Random();        
        int num = random.nextInt(100) + 1;
        int nodesNum = 5;

        SimpleGraph fly = new SimpleGraph(nodesNum);

        for (int i = 0; i < nodesNum; i++ ) {
        	Listing v = new Listing(random.nextInt(300000) + 1);
        	fly.insertVertex(i, v);
        }
        
        for (int i = 0; i < nodesNum; i++ ) {
            int rannum = random.nextInt(5) + 1;
            for (int j = 0; j < rannum; i++ ) {
            	fly.insertEdge(i, random.nextInt(j));
            }
            
        }
       

        fly.insertEdge(0, 1);
		fly.insertEdge(0, 3);
		fly.insertEdge(0, 4);		
		fly.insertEdge(1, 2);
		fly.insertEdge(1, 3);
		fly.insertEdge(2, 1);
		fly.insertEdge(3, 0);
		fly.insertEdge(3, 1);
		fly.insertEdge(3, 4);
		fly.insertEdge(4, 0);
		fly.insertEdge(4, 3);
		
		for(int i = 0; i<5; i++) {
			System.out.print("Vertex" + i + "\'s");
			fly.showVertex(i);
			System.out.print("routes are:\n");
			fly.showEdges(i);
		}
		System.out.print("DFT of graph starting at Vertex 3, V3\n");
//		fly.DFT(3);
		fly.FormulaChoice(fly, 3);
	}
}
