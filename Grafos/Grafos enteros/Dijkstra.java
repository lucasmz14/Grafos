import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    
    private double[] distTo;
    private int[] edgeTo;
    private IndexMinPQ<Double> pq;
    private int s;

    public Dijkstra(EdgeWeightedIntDigraph G, int s){
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new int[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int i = 0 ; i < distTo.length ; i++){
            if(s != i){
                 distTo[i] = Double.POSITIVE_INFINITY;
                 pq.insert(i, distTo[i]);
                 }
       }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for(Edge e : G.adj(v)){
                relax(e);
            }
        }
    }



    private void relax(Edge e){
        int v = e.from;
        int w = e.to;
        if(distTo[w] > distTo[v] + e.weight){
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = v;
            pq.decreaseKey(w, distTo[w]);
        }
    }

     public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }


    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        List<Integer> aux = new LinkedList<>();

        for(int i = v ; i != s ; i = edgeTo[i]){
            aux.addFirst(i);
        }
        aux.addFirst(s);
        return aux;
    }


    public static void main(String[] args) {
    // Crear un grafo con 5 vértices
    EdgeWeightedIntDigraph G = new EdgeWeightedIntDigraph(5);

    // Agregar algunas aristas dirigidas con peso
    G.addEdge(new Edge(0, 1, 2.0));
    G.addEdge(new Edge(0, 2, 4.0));
    G.addEdge(new Edge(1, 2, 1.0));
    G.addEdge(new Edge(1, 3, 7.0));
    G.addEdge(new Edge(2, 4, 3.0));
    G.addEdge(new Edge(3, 4, 1.0));

    // Crear instancia de Dijkstra desde el nodo 0
    Dijkstra dijkstra = new Dijkstra(G, 0);

    // Mostrar distancia y camino mínimo hasta cada nodo
    for (int v = 0; v < 5; v++) {
        if (dijkstra.hasPathTo(v)) {
            System.out.print("Distancia hasta " + v + ": " + dijkstra.distTo[v] + ". Camino: ");
            List<Integer> path = dijkstra.pathTo(v);
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("No hay camino hasta " + v);
        }
    }
}



}

