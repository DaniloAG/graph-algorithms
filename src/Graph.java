import java.util.ArrayList;
import java.util.HashMap;

public class Graph{
	private HashMap<String, Vertex> adjacencyList;

	public Graph(){
		adjacencyList = new HashMap<>();
	}

	public void addVertex(String u){
		adjacencyList.put(u, new Vertex(u));
	}

	public void addEdge(String u, String v){
		addVertexEdge(adjacencyList.get(u), adjacencyList.get(v));
	}

	private void addVertexEdge(Vertex u, Vertex v){
		u.addEdge(new Edge(u, v));
		v.addEdge(new Edge(v, u));
		u.addVertex(v);
		v.addVertex(u);
	}

	public HashMap<String, Vertex> getAdjacencyList() {
		return adjacencyList;
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