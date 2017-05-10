public class Edge{
    private Vertex u;
    private Vertex v;
    private boolean directed;
    private int weight;

    public Edge(Vertex u, Vertex v){
        directed = false;
        weight = 0;
        this.u = u;
        this.v = v;
    }

    public Edge(Vertex u, Vertex v, boolean directed){
        weight = 0;
        this.directed = directed;
        this.u = u;
        this.v = v;
    }

    public Edge(Vertex u, Vertex v, boolean directed, int weight){
        this.directed = directed;
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Vertex getOuterVertex(){
        return u;
    }

    public Vertex getInnerVertex(){
        return v;
    }

    public int getWeight(){
        return weight;
    }

    public boolean isDirected(){
        return directed;
    }

    @Override
    public String toString(){
        return " Edge[ Outer Vertex: " + u.getID() + ", Inner Vertex: " + v.getID()
            + ", Directed: " + directed + ", Weight: " + weight + " ] ";
    }

}