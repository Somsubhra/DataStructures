/**
 * Implementation of a Graph.
 * @author Somsubhra
 */

package LabNull.graphs;


import java.util.Stack;

public class Graph {
	
	private int maxVertices;
	private Vertex[] vertexList;
	private int[][] adjacencyMatrix;
	private int vertices;
	private Stack<Integer> stack;
	
	/**
	 * Constructor of Graph.
	 * @param maxVertices The maximum number of vertices in the graph
	 */
	public Graph(int maxVertices){
		
		vertexList = new Vertex[maxVertices];
		this.maxVertices = maxVertices;
		this.adjacencyMatrix = new int[maxVertices][maxVertices];
		this.vertices = 0;
		
		for(int j=0; j<maxVertices; j++){
		
			for(int k=0 ; k<maxVertices; k++){
			
				adjacencyMatrix[j][k]=0;
				
			}
		}
		
		stack = new Stack<Integer>();
	}
	
	/**
	 * Adds a new Vertex to the graph.
	 * @param label The label of the new vertex
	 */
	public void addVertex(String label){
		
		if(this.vertices==this.maxVertices){
			System.out.println("Error: Overflow.");
			return;
		}
		this.vertexList[this.vertices] = new Vertex(label);
		this.vertices++;
		
	}
	
	
	/**
	 * Adds an edge between two vertices in the graph.
	 * @param start The label of the first vertex
	 * @param end The label of the second vertex
	 */
	public void addEdge(String start, String end){
		int x=-1, y=-1;
		
		for(int i=0; i<this.vertices; i++){
			if(x!=-1 && y!=-1){
				break;
			}
			
			if(this.vertexList[i].label.equals(start)){
				x = i;
			}
			if(this.vertexList[i].label.equals(end)){
				y = i;
			}
		}
		
		if(x==-1 || y==-1){
			System.out.println("Error: No Vertex of the label.");
			return;
		}
		this.adjacencyMatrix[x][y] = 1;
		this.adjacencyMatrix[y][x] = 1;
	}
	
	public void displayAdjacencyMatrix(){
		for(int i=0; i<this.vertices; i++){
			System.out.print("  "+this.vertexList[i].label);
		}
		
		System.out.print("\n");
			
		for(int i=0; i<this.vertices; i++){
			
			System.out.print(this.vertexList[i].label+"  ");
			for(int j=0; j<this.vertices; j++){
				
				System.out.print(adjacencyMatrix[i][j]+"  ");
			}
			
			System.out.print("\n");
		}
	}

}
