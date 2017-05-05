public class Edge{
    private int u;
    private int v;
    private boolean directed;
    private int weight;

    public Edge(int u, int v){
        directed = false;
        this.u = u;
        this.v = v;
    }

    public Edge(boolean directed, int u, int v){
        this.directed = directed;
        this.u = u;
        this.v = v;
    }

    public Edge(boolean directed, int u, int v, int weight){
        this.directed = directed;
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public void setOuterVertex(int u){
        this.u = u;
    }

    public void setInnerVertex(int v){
        this.v = v;
    }

    public int getOuterVertex(){
        return u;
    }

    public int getInnerVertex(){
        return v;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return "Outer Vertex: " + u + " \nInner Vertex: " + v 
            + "\nDirected: " + directed + "\nWeight: " + weight;
    }

}