import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static HashSet<Vertex> visited = new HashSet<>();

    public static void BreadthFirstSearch(Graph G){
        HashMap<String, Vertex> adjacencyList = G.getAdjacencyList();
        for (HashMap.Entry<String, Vertex> vertex : adjacencyList.entrySet()){
            if (!visited.contains(vertex.getValue())){
                BreadthFirstSearch(vertex.getValue());
            }
        }
    }

    private static void BreadthFirstSearch(Vertex vertex){
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()){
            Vertex u = queue.remove();
            visited.add(u);

            System.out.println(u.getID());

            for (Vertex v : u.getAdjacentVertices()){
                if (!visited.contains(v)){
                    queue.add(v);
                }
            }
        }
    }
}
