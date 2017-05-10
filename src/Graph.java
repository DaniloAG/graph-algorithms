import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph{
	private HashMap<String, Vertex> adjacencyList;
	private boolean directedGraph;

	public Graph(boolean isDirected){
		adjacencyList = new HashMap<>();
		directedGraph = isDirected;
	}

	public void addVertex(String u){
		if (!adjacencyList.containsKey(u)){
			adjacencyList.put(u, new Vertex(u));
		}
	}

	public void addEdge(String u, String v){
		if (!adjacencyList.containsKey(u)){
			adjacencyList.put(u, new Vertex(u));
		}

		if (!adjacencyList.containsKey(v)){
			adjacencyList.put(v, new Vertex(v));
		}

		if (!directedGraph){
			addUndirectedEdge(adjacencyList.get(u), adjacencyList.get(v));
		}
		else{
			addDirectedEdge(adjacencyList.get(u), adjacencyList.get(v));
		}
	}

	public void addWeightedEdge(String u, String v, int weight){
		if (!adjacencyList.containsKey(u)){
			adjacencyList.put(u, new Vertex(u));
		}

		if (!adjacencyList.containsKey(v)){
			adjacencyList.put(v, new Vertex(v));
		}

		if (!directedGraph){
			addUndirectedWeightedEdge(adjacencyList.get(u), adjacencyList.get(v), weight);
		}
		else{
			addDirectedWeightedEdge(adjacencyList.get(u), adjacencyList.get(v), weight);
		}
	}

	private void addUndirectedWeightedEdge(Vertex u, Vertex v, int weight){
		u.addEdge(new Edge(u, v, directedGraph, weight));
		v.addEdge(new Edge(v, u, directedGraph, weight));
		u.addVertex(v);
		v.addVertex(u);
	}

	private void addDirectedWeightedEdge(Vertex u, Vertex v, int weight){
		u.addEdge(new Edge(u, v, directedGraph, weight));
		u.addVertex(v);
	}

	private void addUndirectedEdge(Vertex u, Vertex v){
		u.addEdge(new Edge(u, v, directedGraph));
		v.addEdge(new Edge(v, u, directedGraph));
		u.addVertex(v);
		v.addVertex(u);
	}

	private void addDirectedEdge(Vertex u, Vertex v){
		u.addEdge(new Edge(u, v, directedGraph));
		u.addVertex(v);
	}

	public HashMap<String, Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public int[][] getAdjacencyMatrix(){
		int[][] matrix = new int[adjacencyList.size()][adjacencyList.size()];

		int i = 0;
		for (Map.Entry<String, Vertex> entry : adjacencyList.entrySet()){
			int j = 0;
			for (Map.Entry<String, Vertex> entry_two : adjacencyList.entrySet()){
				if (entry.getValue().getAdjacentVertices().contains(entry_two.getValue())){
					matrix[i][j] = 1;
				}
				j++;
			}
			i++;
		}
		
		return matrix;
	}

	public void print2DMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString(){
		StringBuilder graphRepresentation = new StringBuilder();
		graphRepresentation.append("Graph[ ");
		graphRepresentation.append(System.getProperty("line.separator"));

		for (HashMap.Entry<String, Vertex> entry : adjacencyList.entrySet()){
			graphRepresentation.append(entry.getValue());
			graphRepresentation.append(System.getProperty("line.separator"));
		}

		graphRepresentation.append("]");
		return graphRepresentation.toString();
	}
}