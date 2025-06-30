import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Kruskal {
    private List<WeightedEdge> mst;
    private double weight;

    public Kruskal(EdgeWeightedIntGraph G){
        mst = new LinkedList<>();
        WeightedEdge[] edges = new WeightedEdge[G.E()];
        int t = 0;
        for(WeightedEdge e : G.edges()){
            edges[t++] = e;
         }
        Arrays.sort(edges);

        UF uf = new UF (G.V());
        for(int i = 0 ; i < G.E() && mst.size() < G.V() - 1 ; i++){
            WeightedEdge e = edges[i];
            int v = e.from;
            int w = e.to;

            if(uf.find(v) != uf.find(w)){
                mst.add(e);
                uf.union(v, w);
                weight += e.weight;
            }
        }
    }

    public List<WeightedEdge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

        public static void main(String[] args) {
        // Creamos un grafo con 6 vértices (0 a 5)
        EdgeWeightedIntGraph G = new EdgeWeightedIntGraph(6);
        // Agregamos aristas con pesos
        G.addEdge(new WeightedEdge(0, 1, 4.0));
        G.addEdge(new WeightedEdge(0, 2, 8.0));
        G.addEdge(new WeightedEdge(1, 2, 2.0));
        G.addEdge(new WeightedEdge(1, 3, 5.0));
        G.addEdge(new WeightedEdge(2, 3, 5.0));
        G.addEdge(new WeightedEdge(2, 4, 9.0));
        G.addEdge(new WeightedEdge(3, 4, 4.0));
        G.addEdge(new WeightedEdge(3, 5, 7.0));
        G.addEdge(new WeightedEdge(4, 5, 6.0));

        // Ejecutamos Kruskal
        Kruskal mst = new Kruskal(G);

        // Mostramos las aristas del MST
        System.out.println("Aristas en el MST:");
        for (WeightedEdge e : mst.edges()) {
            System.out.printf("%d - %d (peso: %.2f)\n", e.from, e.to, e.weight);
        }
        // Mostramos el peso total
        System.out.printf("Peso total del MST: %.2f\n", mst.weight());
    }
}
