public class GraphAlgorithmsManager{
	public static void main(String[] args){
		Graph graph = new Graph(true);

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");

		graph.addWeightedEdge("A", "B", 2);
		graph.addWeightedEdge("A", "C", 5);
		graph.addWeightedEdge("B", "D", 1);

		FloydWarshallAlgorithm.FloydWarshallAlgorithm(graph);

	}
}