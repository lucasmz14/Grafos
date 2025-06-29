import java.util.LinkedList;
import java.util.List;

public class Prim {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    private int s;
    private boolean[] marked;
    private EdgeWeightedIntGraph G;


    public Prim(EdgeWeightedIntGraph G , int s){
        this.G = G;
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int i = 0 ; i < G.V(); i++){
            if(i != s){
            distTo[i] = Double.POSITIVE_INFINITY;
            pq.insert(i, distTo[i]);
            }else{
                distTo[s] = 0.0;
            }
        }
        pq.insert(s, 0.0);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            marked[v] = true;
            for(DirectedEdge e : G.adj(v)){
                if(!marked[e.to] && e.weight < distTo[e.to]){
                    edgeTo[e.to] = e;
                    distTo[e.to] = e.weight; 
                    pq.decreaseKey(e.to, distTo[e.to]);
                }
            }
        }

    }


    public List<DirectedEdge> MST(){
        List<DirectedEdge> aux = new LinkedList<>();

        for(int i = 0 ; i < edgeTo.length ; i++){
            if(edgeTo[i] != null){
            aux.add(edgeTo[i]);
            }
        }

        return aux;
        
    }

    public double weight(){
        double aux = 0.0;

        for(int i = 0 ; i < edgeTo.length; i++){
            if(edgeTo[i] != null){
            aux += edgeTo[i].weight;
            }
        }
        return aux;
    }

    public static void main(String[] args) {
        int V = 4;
        EdgeWeightedIntGraph G = new EdgeWeightedIntGraph(V);

        // Agrego aristas: (from, to, peso)
        G.addEdge(new DirectedEdge(0, 1, 1.0));

        G.addEdge(new DirectedEdge(0, 3, 4.0));

        G.addEdge(new DirectedEdge(1, 3, 2.0));

        // Ejecutar Prim desde el nodo 0
        Prim prim = new Prim(G, 0);

        System.out.println("Aristas del MST:");
        for (DirectedEdge e : prim.MST()) {
            if (e != null) {
                System.out.println(e.from + " — " + e.to + " (peso " + e.weight + ")");
            }
        }

        System.out.println("Peso total del MST: " + prim.weight());
    }

}
