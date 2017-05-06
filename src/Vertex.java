import java.util.ArrayList;

public class Vertex{
	private String ID;
	private ArrayList<Edge> edges;
	private ArrayList<Vertex> adjacentVertices;

	public Vertex(String ID){
		edges = new ArrayList<>();
		adjacentVertices = new ArrayList<>();
		this.ID = ID;
	}

	public void addEdge(Edge edge){
		edges.add(edge);
	}

	public void addVertex(Vertex vertex){
		adjacentVertices.add(vertex);
	}

	public ArrayList<Edge> getEdges(){
		return edges;
	}

	public ArrayList<Vertex> getAdjacentVertices(){
		return adjacentVertices;
	}

	public String getID(){
		return ID;
	}

	public int getOutDegree(){
		return edges.size();
	}

	@Override
	public String toString(){
		StringBuilder adjacentVerticesRepresentation = new StringBuilder();

		for (Vertex vertex : adjacentVertices){
			adjacentVerticesRepresentation.append(vertex.getID()).append(" ");
		}

		return "Vertex[ ID: " + ID + ", Edges: " +  edges + ", Adjacent Vertices: [ " + adjacentVerticesRepresentation.toString() + "] ] ";
	}

}