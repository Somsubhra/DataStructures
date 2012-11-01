/**
 * Implemetation of vertex of a graph.
 * @author Somsubhra
 */

package LabNull.graphs;

public class Vertex {
	
	String label;
	
	boolean wasVisited;
	
	
	/**
	 * Constructor of vertex of a graph.
	 * @param label The label of the vertex
	 */
	public Vertex(String label){
		
		this.label = label;
		this.wasVisited = false;
		
	}

}
