package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp3;

import java.util.Iterator;

import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp3.BFS.BFSVertex;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp3.DMSTGraph.DMSTEdge;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp3.DMSTGraph.DMSTVertex;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph.Edge;
import cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.utilities.Graph.Vertex;


// Very inefficient codes. Lots of iterations of nodes. Should optimize later. 
public class FindDirectedMst {
	
	
	public Graph minMst(DMSTGraph g, Vertex start) {
		g = transformWeights(g, start);
		g = findSubGraph(g);
		if(isMST(g, start)){
			return g;
		}
	
		return g;
	}
	
	public boolean isMST(DMSTGraph g, Vertex start){
		BFS bfs = new BFS(g,start);
		bfs.bfs();
		BFSVertex[] vertexArr = bfs.node;
		for(BFSVertex vertex : vertexArr){
			if(!vertex.seen){
				return false;
			}
		}
		return true;
	}
	
	private DMSTGraph findSubGraph(DMSTGraph g) {
		DMSTVertex[] vertexArr = g.getDMSTVertexArray();
		for(DMSTVertex vertex : vertexArr){
			Iterator<DMSTEdge> it = vertex.xadj.iterator();
			while(it.hasNext()){
				DMSTEdge edge = it.next();
				if(edge.weight != 0){
					edge.disabled();
				}
			}
			
		}
		return g;
	}

	public DMSTGraph transformWeights(DMSTGraph g, Vertex start) {
		DMSTVertex[] vertexArray = g.getDMSTVertexArray();
		for (DMSTVertex vertex : vertexArray) {
			// try to remove this if condition
			if (vertex.getName() != start.getName()) {
				for (Edge e : vertex.revAdj) {
					e.weight = e.weight - vertex.minEdge;
				}
			}
		}
		return g;
	}

}