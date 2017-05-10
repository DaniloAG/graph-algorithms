public class GraphAlgorithmsManager{
	public static void main(String[] args){
		Graph graph = new Graph(false);

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");

		graph.addWeightedEdge("A", "B", 22);
		graph.addWeightedEdge("A", "C", 9);
		graph.addWeightedEdge("A", "D", 12);

		graph.addWeightedEdge("B", "A", 22);		
		graph.addWeightedEdge("B", "H", 34);
		graph.addWeightedEdge("B", "C", 35);
		graph.addWeightedEdge("B", "F", 36);
		
		graph.addWeightedEdge("C", "B", 35);
		graph.addWeightedEdge("C", "A", 9);
		graph.addWeightedEdge("C", "F", 42);
		graph.addWeightedEdge("C", "E", 65);
		graph.addWeightedEdge("C", "D", 4);

		graph.addWeightedEdge("D", "A", 12);
		graph.addWeightedEdge("D", "C", 4);
		graph.addWeightedEdge("D", "E", 33);
		graph.addWeightedEdge("D", "I", 30);

		graph.addWeightedEdge("E", "D", 33);
		graph.addWeightedEdge("E", "C", 65);
		graph.addWeightedEdge("E", "F", 18);
		graph.addWeightedEdge("E", "G", 23);

		graph.addWeightedEdge("F", "B", 36);
		graph.addWeightedEdge("F", "H", 24);
		graph.addWeightedEdge("F", "C", 42);
		graph.addWeightedEdge("F", "E", 18);
		graph.addWeightedEdge("F", "G", 39);

		graph.addWeightedEdge("G", "E", 23);
		graph.addWeightedEdge("G", "F", 39);
		graph.addWeightedEdge("G", "H", 25);
		graph.addWeightedEdge("G", "I", 21);

		graph.addWeightedEdge("H", "B", 34);
		graph.addWeightedEdge("H", "G", 25);
		graph.addWeightedEdge("H", "F", 24);
		graph.addWeightedEdge("H", "I", 19);

		graph.addWeightedEdge("I", "H", 19);
		graph.addWeightedEdge("I", "G", 21);
		graph.addWeightedEdge("I", "D", 30);

		FloydWarshallAlgorithm.FloydWarshallAlgorithm(graph);

	}
}