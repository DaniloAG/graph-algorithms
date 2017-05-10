import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;


public class FloydWarshallAlgorithm{

	public static int[][] FloydWarshallAlgorithm(Graph G){
		int[][] matrix = G.getAdjacencyMatrix();
		HashMap<String, Vertex> adjacencyList = G.getAdjacencyList();

		int[][] dist = new int[matrix[0].length][matrix[0].length];
		int[][] path = new int[matrix[0].length][matrix[0].length];

		int m = 0;
		for (HashMap.Entry<String, Vertex> v : adjacencyList.entrySet()){
			int j = 0;
			for (HashMap.Entry<String, Vertex> v_2 : adjacencyList.entrySet()){
				if (v.getValue().getAdjacentVertices().contains(v_2.getValue())){
					for (Edge edge : v.getValue().getEdges()){
						if (edge.getOuterVertex().equals(v.getValue()) && edge.getInnerVertex().equals(v_2.getValue())){
							dist[m][j] = edge.getWeight();

							if (matrix[m][j] != Integer.MAX_VALUE && m != j) {
								path[m][j] = m;
							} 
							else {
								path[m][j] = -1;
							}

							break;
						}
					}
				}
				else{
					dist[m][j] = Integer.MAX_VALUE;
				}
				j++;
			}
			m++;
		}

		m = 0;
		for (HashMap.Entry<String, Vertex> v : adjacencyList.entrySet()){
			int j = 0;
			for (HashMap.Entry<String, Vertex> v_2 : adjacencyList.entrySet()){
				if (v.getKey().equals(v_2.getKey())){
					dist[m][j] = 0;
				}
				j++;
			}
			m++;
		}

		for (int k = 0; k < matrix[0].length; k++){
			for (int i = 0; i < matrix[0].length; i++){
				for (int j = 0; j < matrix[0].length; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
				}
			}
		}

		G.print2DMatrix(dist);
		System.out.println();
		G.print2DMatrix(path);

		// for(int i = 0; i < matrix[0].length; i++) {
  //           if(dist[i][i] < 0) {
  //               throw new NegativeWeightCycleException();
  //           }
  //       }

        System.out.println();

        printPath(path, 0, 3);
		return dist;
	}

	// All credit for this method goes to, Tushar Roy.
	private static void printPath(int[][] path, int start, int end) {
        if(start < 0 || end < 0 || start >= path.length || end >= path.length) {
            throw new IllegalArgumentException();
        }

        System.out.println("Actual path - between " + start + " " + end);
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(end);
        while (true) {
            end = path[start][end];
            if(end == -1) {
                return;
            }
            stack.addFirst(end);
            if(end == start) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }

        System.out.println();
    }
}