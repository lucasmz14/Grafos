import java.util.LinkedList;
import java.util.List;

public class FloydWarshall {
    private double[][] distTo;
    private Edge[][] edgeTo;
    private EdgeWeightedIntDigraph G;

    public FloydWarshall(EdgeWeightedIntDigraph G){
        int v = G.V();
        distTo = new double[v][v];
        edgeTo = new Edge[v][v];
        fw(G);
    }
    

    private void fw(EdgeWeightedIntDigraph G){
        for(int i = 0 ; i < G.V(); i++){
            for(int j = 0 ; j < G.V(); j++){
                if(i == j){
                    distTo[i][j] = 0;
                }else{
                    distTo[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        for(int i = 0 ; i < G.V(); i++){
            for(Edge e : G.adj(i)){
                distTo[e.from][e.to] = e.weight;
                edgeTo[e.from][e.to] = e;
            }

        }

        for(int k = 0 ; k < G.V(); k++){
            for(int i = 0 ; i < G.V(); i++){
                for(int j = 0 ; j < G.V() ; j++){
                    if(distTo[i][j] > distTo[i][k] + distTo[k][j]){
                        distTo[i][j] = distTo[i][k] + distTo[k][j];
                        edgeTo[i][j] = edgeTo[k][j];
                    }
                }
            }
        }
    }

     public boolean hasPathTo(int v, int w){
        return distTo[v][w] < Double.POSITIVE_INFINITY;
    }


    public List<Edge> pathTo(int v , int w){
        if(!hasPathTo(v,w)){
            return null;
        }

        List<Edge> aux = new LinkedList<>();
        
        for(int i = v; i <= w ; i++){
            if(edgeTo[v][i] != null){
            aux.add(edgeTo[v][i]);
            }
        }
        return aux;
    }

    public static void main(String[] args) {
        int V = 4;
        EdgeWeightedIntDigraph graph = new EdgeWeightedIntDigraph(V);

        graph.addEdge(new Edge(0, 1, 5));
        graph.addEdge(new Edge(0, 3, 10));
        graph.addEdge(new Edge(1, 2, 3));
        graph.addEdge(new Edge(1, 3, 15));
        graph.addEdge(new Edge(2, 3, 1));

        FloydWarshall fw = new FloydWarshall(graph);

        int from = 1;
        int to = 3;

        if (fw.hasPathTo(from, to)) {
            System.out.println("Camino de " + from + " a " + to + ":");
            for (Edge e : fw.pathTo(from, to)) {
                System.out.println(e.from() + " -> " + e.to() + " (" + e.weight() + ")");
            }
        } else {
            System.out.println("No hay camino de " + from + " a " + to);
        }
    }
}
