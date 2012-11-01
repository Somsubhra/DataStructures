/**
 * Tester of Graph.
 * @author Somsubhra
 */

package LabNull.graphs;

public class GraphTester {

	
	public static void main(String[] args){
		Graph g = new Graph(10);
		
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		
		g.addEdge("a", "b");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "a");
		
		g.displayAdjacencyMatrix();
		
	}
}
