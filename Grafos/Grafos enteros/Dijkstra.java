import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.border.LineBorder;

public class Dijkstra {
    private EdgeWeightedIntDigraph G;
    private int s;
    private IndexMinPQ<Double> pq;
    private double[] distTo;
    private WeightedEdge[] edgeTo;

    public Dijkstra(EdgeWeightedIntDigraph G , int s){
        this.G = G;
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new WeightedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int i = 0 ; i < G.V() ; i++){
            if( s != i){
                distTo[i] = Double.POSITIVE_INFINITY;
                pq.insert(i, distTo[i]);
            }else{
                distTo[s] = 0.0;
                pq.insert(i, 0.0);
            }
        }
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for(WeightedEdge e : G.adj(v)){
                relax(e);
            }


        }
    }

    public void relax(WeightedEdge e){
        int v = e.from;
        int w = e.to;
        if(distTo[w] > distTo[v] + e.weight){
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            pq.decreaseKey(w, distTo[w]);
        }
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public List<WeightedEdge> pathTo(int v){
        if(!hasPathTo(v)){
            throw new IllegalArgumentException();
        }
        List<WeightedEdge> aux = new LinkedList<>();

        for(WeightedEdge e = edgeTo[v] ; e != null ; e = edgeTo[e.from]){
            aux.addFirst(e);
        }
        return aux;
    }

    public static void main(String[] args) {
    // Crear un grafo con 5 vértices
    EdgeWeightedIntDigraph G = new EdgeWeightedIntDigraph(5);

    // Agregar algunas aristas dirigidas con peso
    G.addEdge(new WeightedEdge(0, 1, 2.0));
    G.addEdge(new WeightedEdge(0, 2, 4.0));
    G.addEdge(new WeightedEdge(1, 2, 1.0));
    G.addEdge(new WeightedEdge(1, 3, 7.0));
    G.addEdge(new WeightedEdge(2, 4, 3.0));
    G.addEdge(new WeightedEdge(3, 4, 1.0));

    // Crear instancia de Dijkstra desde el nodo 0
    Dijkstra dijkstra = new Dijkstra(G, 0);

    // Mostrar distancia y camino mínimo hasta cada nodo
    for (int v = 0; v < 5; v++) {
        if (dijkstra.hasPathTo(v)) {
            System.out.print("Distancia hasta " + v + ": " + dijkstra.distTo[v] + ". Camino: ");
            List<WeightedEdge> path = dijkstra.pathTo(v);
            for (WeightedEdge node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("No hay camino hasta " + v);
        }
    }
}



}

