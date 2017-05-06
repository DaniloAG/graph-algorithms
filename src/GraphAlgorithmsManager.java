public class GraphAlgorithmsManager{
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

		DFS.DepthFirstSearch(graph);
	}
}