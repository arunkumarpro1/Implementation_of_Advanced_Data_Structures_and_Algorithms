package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities;

/**
 * Graph class customized to do topological ordering by removing the indegree edges 
 * 
 * @author Ashwin, Arun, Deepak, Haritha
 *
 */

import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.GraphAlgorithm;

public class TopoGraph extends GraphAlgorithm<TopoGraph.TopoVertex> {

	public class TopoVertex {
		Graph.Vertex element;
		Graph.Vertex parent;
		public int inDegree;
		int top;
		public boolean seen;
		
		TopoVertex(Graph.Vertex u) {
			element = u;
			top = -1;
			seen = false;
		}
	}

	public TopoGraph(Graph g) {
		super(g);
		node = new TopoVertex[g.size()];
		for (Graph.Vertex u : g) {
			node[u.getName()] = new TopoVertex(u);
		}
	}

	public int reduceInDegree(Graph.Vertex u) {
		return --getVertex(u).inDegree;
	}
	
	public int increaseInDegree(Graph.Vertex u) {
		return ++getVertex(u).inDegree;
	}
}
