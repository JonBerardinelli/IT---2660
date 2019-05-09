
public class DriverFinal {

	public static void main(String[] args) {
        int nodesNum = 100000;
        SimpleGraph graph = new SimpleGraph(nodesNum);
        
        graph.InitializeNodes(graph, nodesNum);

        for(int i = 0; i<5; i++) {
			System.out.print("Node " + i + "\'s ");
			graph.showVertex(i);
			System.out.print("Its routes are:\n");
			graph.showEdges(i);
		}
        
        int select = graph.Search();
		graph.FormulaChoice(graph, select);
	}
}
