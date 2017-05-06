import java.util.HashMap;
import java.util.HashSet;

public class DFS{
	private static HashSet<Vertex> visited = new HashSet<>();

	private static void DepthFirstSearch(Graph G){
		HashMap<String, Vertex> adjacencyList = G.getAdjacencyList();
		for (HashMap.Entry<String, Vertex> vertex : adjacencyList.entrySet()){
			if (!visited.contains(vertex.getValue())){
				DepthFirstSearch(vertex.getValue());
			}
		}
	}

	private static void DepthFirstSearch(Vertex v){
		visited.add(v);
		System.out.println(v.getID());
		for (Vertex vertex : v.getAdjacentVertices()){
			if (!visited.contains(vertex)){
				DepthFirstSearch(vertex);
			}
		}
	}


	public static void main(String[] args){
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");

		DepthFirstSearch(graph);
	}
}